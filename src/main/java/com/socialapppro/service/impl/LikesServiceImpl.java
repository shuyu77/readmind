package com.socialapppro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.socialapppro.domain.dto.LikeDTO;
import com.socialapppro.domain.entity.Likes;
import com.socialapppro.domain.entity.Posts;
import com.socialapppro.mapper.LikesMapper;
import com.socialapppro.mapper.PostsMapper;
import com.socialapppro.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2024-03-27
 */
@Service
public class LikesServiceImpl extends ServiceImpl<LikesMapper, Likes> implements LikesService {

    @Autowired
    private LikesMapper likesMapper;

    @Autowired
    private PostsMapper postsMapper;

    @Override
    public List<Likes> findByuserId(Integer userId) {
        QueryWrapper<Likes> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        return likesMapper.selectList(queryWrapper);
    }
    @Override
    public Long likesByPostId(Integer postId) {
        QueryWrapper<Likes> wrapper = new QueryWrapper<>();
        wrapper.eq("post_id", postId);
        return likesMapper.selectCount(wrapper);
    }

    @Override
    public boolean addlikesByPostId(Integer postId, Integer userId) {
        Likes likes = new Likes();
        likes.setPostId(postId);
        likes.setUserId(userId);
        return likesMapper.insert(likes) == 1;
    }

    @Override
    public boolean deletelikesByPostId(Integer postId, Integer userId) {
        QueryWrapper<Likes> wrapper = new QueryWrapper<>();
        wrapper.eq("post_id", postId);
        wrapper.eq("user_id", userId);
        return likesMapper.delete(wrapper) == 1;
    }

    @Override
    public boolean getlikesByPostId(Integer postId, Integer userId) {
        QueryWrapper<Likes> wrapper = new QueryWrapper<>();
        wrapper.eq("post_id", postId);
        wrapper.eq("user_id", userId);
        Likes likes = likesMapper.selectOne(wrapper);
        return likes != null;
    }

    @Override
    public List<Likes> getLikedPostByUserId(Integer userId) {
        QueryWrapper<Likes> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        wrapper.orderByDesc("created_at");
        return likesMapper.selectList(wrapper);
    }

    @Override
    public Object ListByUserId(Integer userId) {
        List<Posts> postsList = postsMapper.getPostByUserId(userId);
        List<LikeDTO> allLikes = new ArrayList<>();

        postsList.forEach(item -> {
            List<LikeDTO> likeDTOList = likesMapper.ListByUserId(item.getPostId());
            allLikes.addAll(likeDTOList);
        });

        // 按时间排序
        List<LikeDTO> sortedLikes = allLikes.stream()
                .sorted(Comparator.comparing(LikeDTO::getCreatedAt).reversed())
                .collect(Collectors.toList());

        return sortedLikes;
    }

    @Override
    public void updatePostLikes(Integer postId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("post_id", postId); // 假设您有一个变量 postId
        Integer count = Math.toIntExact(likesMapper.selectCount(wrapper));
        Posts posts = new Posts();
        posts.setPostId(postId);
        posts.setLikesCount(count);
        postsMapper.updateById(posts);
    }

}

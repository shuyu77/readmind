package com.socialapppro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.socialapppro.domain.dto.CommentDTO;
import com.socialapppro.domain.entity.Comments;
import com.socialapppro.domain.entity.Posts;
import com.socialapppro.mapper.CommentsMapper;
import com.socialapppro.mapper.PostsMapper;
import com.socialapppro.service.CommentsService;
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
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements CommentsService {

    @Autowired
    CommentsMapper commentsMapper;

    @Autowired
    PostsMapper postsMapper;

    @Override
    public List<Comments> getCommentsBypostId(Integer postId) {
        List<Comments> commentsList = commentsMapper.getCommentsBypostId(postId);
        return commentsList;
    }
    @Override
    public void add(Comments comments) {
        commentsMapper.add(comments);
    }
    @Override
    public Comments findByUserId(Integer id) {
        Comments comments = commentsMapper.findByUserId(id);
        return comments;
    }

    @Override
    public void update(Comments comments) {
        commentsMapper.update(comments);
    }

    @Override
    public Object ListMyComment(Integer userId) {
        List<Posts> postsList = postsMapper.getPostByUserId(userId);
        List<CommentDTO> commentDTOS = new ArrayList<>();

        postsList.forEach(item -> {
            List<CommentDTO> listMyComment = commentsMapper.ListMyComment(item.getPostId());
            commentDTOS.addAll(listMyComment);
        });

        // 按时间排序
        List<CommentDTO> sortedLikes = commentDTOS.stream()
                .sorted(Comparator.comparing(CommentDTO::getCreatedAt).reversed())
                .collect(Collectors.toList());

        return sortedLikes;
    }

    @Override
    public void updatePostcomment(Integer postId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("post_id", postId); // 假设您有一个变量 postId
        Integer count = Math.toIntExact(commentsMapper.selectCount(wrapper));
        Posts posts = new Posts();
        posts.setPostId(postId);
        posts.setCommentsCount(count);
        postsMapper.updateById(posts);
    }
}

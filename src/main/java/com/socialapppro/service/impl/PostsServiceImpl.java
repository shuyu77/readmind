package com.socialapppro.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.socialapppro.domain.dto.ArticleDTO;
import com.socialapppro.domain.entity.*;
import com.socialapppro.mapper.*;
import com.socialapppro.service.PostsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.socialapppro.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2024-03-27
 */
@Service
public class PostsServiceImpl extends ServiceImpl<PostsMapper, Posts> implements PostsService {

    @Autowired
    PostsMapper postsMapper;

    @Autowired
    PostTagsMapper postTagsMapper;

    @Autowired
    PicturesMapper picturesMapper;

    @Autowired
    TagsMapper tagsMapper;

    @Override
    public List<Posts> getPostAll() {
        return postsMapper.getPostAll();
    }

    @Override
    public List<Posts> getNewActivity() {
        return postsMapper.getNewActivity();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addPost(JSONObject obj) {
        try {
            if(StringUtils.isAllNor(obj.getString("inputText")) ||  StringUtils.isAllSpan(obj.getString("inputText"))){
                return false;
            }
            else {
                Posts posts = new Posts();
                posts.setUserId(obj.getInteger("userId"));
                posts.setContent(obj.getString("inputText"));
                posts.setTitle("1");
                JSONArray imageArray = obj.getJSONArray("imgList");
                JSONArray tagArray = obj.getJSONArray("inputTag");
                if(imageArray != null && imageArray.size() > 0) posts.setImages(imageArray.getJSONObject(0).getString("url"));
                else {
                    if(new Random().nextInt(2) != 0){ // 生成0或1的随机整数
                        posts.setImages("http://8.138.112.13:8180/social/默认图片1.png");
                    }
                    else{
                        posts.setImages("http://8.138.112.13:8180/social/默认图片2.png");
                    }
                }
                postsMapper.insert(posts);
                for (int i = 0; i < imageArray.size(); i++) {
                    Pictures pictures = new Pictures();
                    pictures.setPostsId(posts.getPostId());
                    pictures.setImage(imageArray.getJSONObject(i).getString("url"));
                    picturesMapper.insert(pictures);
                }
                for (int i = 0; i < tagArray.size(); i++) {
                    PostTags postTags = new PostTags();
                    postTags.setPostId(posts.getPostId());
                    //先查询是否存在这个标签
                    QueryWrapper<Tags> wrapper = new QueryWrapper<>();
                    wrapper.eq("tag_name", tagArray.getString(i));
                    Tags tags = tagsMapper.selectOne(wrapper);
                    if (tags == null) {
                        tags = new Tags();
                        tags.setTagName(tagArray.getString(i));
                        tagsMapper.insert(tags);
                    }
                    postTags.setTagId(tags.getTagId());
                    postTagsMapper.insert(postTags);
                }
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Posts> getPostByUserId(Integer userId) {
        return postsMapper.getPostByUserId(userId);
    }

    @Override
    public ArticleDTO getPostsById(Integer postId) {
        return postsMapper.getPostsById(postId);
    }

    @Override
    public List<Posts> getPostAllMyUserId(Integer userId) {
        return postsMapper.getPostAllMyUserId(userId);
    }

    @Override
    public void add(Posts posts) {
        posts.setCreatedAt(LocalDateTime.now());
        posts.setUpdatedAt(LocalDateTime.now());
        postsMapper.add(posts);
    }
}


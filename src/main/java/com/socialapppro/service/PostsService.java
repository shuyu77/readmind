package com.socialapppro.service;

import com.alibaba.fastjson.JSONObject;
import com.socialapppro.domain.dto.ArticleDTO;
import com.socialapppro.domain.entity.Posts;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2024-03-27
 */
public interface PostsService extends IService<Posts> {

    List<Posts> getPostAll();

    void add(Posts posts);

    List<Posts> getNewActivity();

    boolean addPost(JSONObject obj);

    List<Posts> getPostByUserId(Integer userId);

    ArticleDTO getPostsById(Integer postId);

    List<Posts> getPostAllMyUserId(Integer userId);
}

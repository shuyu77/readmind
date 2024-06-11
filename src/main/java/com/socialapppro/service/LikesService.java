package com.socialapppro.service;

import com.socialapppro.domain.entity.Likes;
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
public interface LikesService extends IService<Likes> {
    List<Likes> findByuserId(Integer userId);

    Long likesByPostId(Integer postId);

    boolean addlikesByPostId(Integer postId, Integer userId);

    boolean deletelikesByPostId(Integer postId, Integer userId);

    boolean getlikesByPostId(Integer postId, Integer userId);

    List<Likes> getLikedPostByUserId(Integer userId);

    Object ListByUserId(Integer userId);

    void updatePostLikes(Integer postId);
}

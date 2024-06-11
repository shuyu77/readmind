package com.socialapppro.service;

import com.socialapppro.domain.entity.Comments;
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
public interface CommentsService extends IService<Comments> {

    Comments findByUserId(Integer id);

    List<Comments> getCommentsBypostId(Integer postId);

    void add(Comments comments);

    void update(Comments comments);

    Object ListMyComment(Integer userId);

    void updatePostcomment(Integer postId);
}

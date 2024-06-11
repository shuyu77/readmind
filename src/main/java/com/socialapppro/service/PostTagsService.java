package com.socialapppro.service;

import com.socialapppro.domain.entity.PostTags;
import com.baomidou.mybatisplus.extension.service.IService;
import com.socialapppro.domain.entity.Posts;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2024-03-27
 */
public interface PostTagsService extends IService<PostTags> {
     List<Posts> getAll(Integer id);
}

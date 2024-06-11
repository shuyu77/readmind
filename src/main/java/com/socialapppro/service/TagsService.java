package com.socialapppro.service;

import com.socialapppro.domain.entity.Tags;
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
public interface TagsService extends IService<Tags> {

    void add(Tags tags);

    List<Tags> findByName(Integer name);

    void update(Tags tags);
}

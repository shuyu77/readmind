package com.socialapppro.service;

import com.socialapppro.domain.entity.Schools;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2024-03-27
 */
public interface SchoolsService extends IService<Schools> {

    void add(Schools schools);

    void update(Schools schools);
}

package com.socialapppro.service;

import com.socialapppro.domain.entity.Colleges;
import com.socialapppro.domain.entity.Schoolcolleges;
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
public interface SchoolcollegesService extends IService<Schoolcolleges> {

    List<Colleges> getcolleges(String name);
}

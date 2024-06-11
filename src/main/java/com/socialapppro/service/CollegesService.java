package com.socialapppro.service;

import com.socialapppro.VO.PageBean;
import com.socialapppro.domain.entity.Colleges;
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
public interface CollegesService extends IService<Colleges> {

    void add(Colleges colleges);

    Colleges findById(Integer id);

    void update(Colleges colleges);

    PageBean<Colleges> list(Integer pageNum, Integer pageSize, String schoolId);

    List<Colleges> listConfirm(String schoolId);
}

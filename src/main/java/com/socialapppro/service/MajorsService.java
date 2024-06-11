package com.socialapppro.service;

import com.socialapppro.VO.PageBean;
import com.socialapppro.domain.entity.Majors;
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
public interface MajorsService extends IService<Majors> {

    void add(Majors majors);

    void update(Majors majors);

    PageBean<Majors> list(Integer pageNum, Integer pageSize, String collegeId);

    List<Majors> listConfirm(String collegeId);
}

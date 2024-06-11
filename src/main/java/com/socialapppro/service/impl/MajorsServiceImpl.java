package com.socialapppro.service.impl;

import com.github.pagehelper.PageHelper;
import com.socialapppro.VO.PageBean;
import com.github.pagehelper.Page;
import com.socialapppro.domain.entity.Colleges;
import com.socialapppro.domain.entity.Majors;
import com.socialapppro.mapper.MajorsMapper;
import com.socialapppro.service.MajorsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2024-03-27
 */
@Service
public class MajorsServiceImpl extends ServiceImpl<MajorsMapper, Majors> implements MajorsService {

    @Autowired
    private MajorsMapper majorsMapper;
    @Override
    public void add(Majors majors) {
        majorsMapper.add(majors);
    }

    @Override
    public void update(Majors majors) {
        majorsMapper.update(majors);
    }
    @Override
    public PageBean<Majors> list(Integer pageNum, Integer pageSize, String collegeId) {
        PageBean<Majors>pageBean=new PageBean<>();
        PageHelper.startPage(pageNum,pageSize);
        List<Majors> as=majorsMapper.list(collegeId);

        Page<Majors> resultPage=(Page<Majors>)as;
        pageBean.setTotal(resultPage.getTotal());
        pageBean.setItems(resultPage.getResult());
        return pageBean;
    }
    @Override
    public List<Majors> listConfirm(String majorId) {
        return majorsMapper.list(majorId);
    }
}

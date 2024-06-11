package com.socialapppro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.socialapppro.VO.PageBean;
import com.socialapppro.domain.entity.Colleges;
import com.socialapppro.mapper.CollegesMapper;
import com.socialapppro.service.CollegesService;
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
public class CollegesServiceImpl extends ServiceImpl<CollegesMapper, Colleges> implements CollegesService {

    @Autowired
    CollegesMapper collegesMapper;

    @Override
    public void add(Colleges colleges) {
        collegesMapper.add(colleges);
    }
    @Override
    public Colleges findById(Integer id) {
        Colleges colleges = collegesMapper.findById(id);
        return colleges;
    }

    @Override
    public void update(Colleges colleges) {
        collegesMapper.update(colleges);
    }
    @Override
    public PageBean<Colleges> list(Integer pageNum, Integer pageSize, String schoolId) {
        PageBean<Colleges>pageBean=new PageBean<>();
        PageHelper.startPage(pageNum,pageSize);
        List<Colleges> as=collegesMapper.list(schoolId);

        Page<Colleges> resultPage = (Page<Colleges>) as;
        pageBean.setTotal(resultPage.getTotal());
        pageBean.setItems(resultPage.getResult());
        return pageBean;
    }

    @Override
    public List<Colleges> listConfirm(String schoolId) {
//        QueryWrapper wrapper = new QueryWrapper<>();
//        wrapper.eq("school_id", )
        return collegesMapper.list(schoolId);
    }
}

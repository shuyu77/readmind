package com.socialapppro.service.impl;

import com.socialapppro.domain.entity.Colleges;
import com.socialapppro.domain.entity.Schoolcolleges;
import com.socialapppro.mapper.SchoolcollegesMapper;
import com.socialapppro.service.SchoolcollegesService;
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
public class SchoolcollegesServiceImpl extends ServiceImpl<SchoolcollegesMapper, Schoolcolleges> implements SchoolcollegesService {
    @Autowired
    SchoolcollegesMapper schoolsMapper;

    @Override
    public List<Colleges> getcolleges(String name) {
        return schoolsMapper.getCollegename(name);
    }
}

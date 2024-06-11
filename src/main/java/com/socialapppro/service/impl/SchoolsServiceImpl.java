package com.socialapppro.service.impl;

import com.socialapppro.domain.entity.Schools;
import com.socialapppro.mapper.SchoolsMapper;
import com.socialapppro.service.SchoolsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2024-03-27
 */
@Service
public class SchoolsServiceImpl extends ServiceImpl<SchoolsMapper, Schools> implements SchoolsService {

    @Autowired
    private SchoolsMapper schoolsMapper;
    @Override
    public void add(Schools schools) {
        schoolsMapper.add(schools);
    }

    @Override
    public void update(Schools schools) {
        schoolsMapper.update(schools);
    }
}

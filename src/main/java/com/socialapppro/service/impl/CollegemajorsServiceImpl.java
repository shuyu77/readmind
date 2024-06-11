package com.socialapppro.service.impl;

import com.socialapppro.domain.entity.Collegemajors;
import com.socialapppro.domain.entity.Majors;
import com.socialapppro.mapper.CollegemajorsMapper;
import com.socialapppro.service.CollegemajorsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2024-04-05
 */
@Service
public class CollegemajorsServiceImpl extends ServiceImpl<CollegemajorsMapper, Collegemajors> implements CollegemajorsService {

    @Autowired
    CollegemajorsMapper collegemajorsMapper;
    @Override
    public List<Majors> getMajors(String college) {
        return collegemajorsMapper.getMajors(college);
    }
}

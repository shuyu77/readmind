package com.socialapppro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.socialapppro.domain.entity.Collegemajors;
import com.socialapppro.domain.entity.Majors;

import java.util.List;

public interface CollegemajorsService extends IService<Collegemajors> {
    List<Majors> getMajors(String college);
}

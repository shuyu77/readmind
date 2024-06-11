package com.socialapppro.controller;


import com.socialapppro.VO.ResultVO;
import com.socialapppro.domain.entity.Majors;
import com.socialapppro.service.CollegemajorsService;
import com.socialapppro.util.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author author
 * @since 2024-04-05
 */
@RestController
@RequestMapping("/collegemajors")
public class CollegemajorsController {

    @Autowired
    CollegemajorsService collegemajorsService;

    @GetMapping("/getmajors/{college}")
    public ResultVO getcolleges(@PathVariable("college") String college){
        List<Majors> schoolcollegesVo = collegemajorsService.getMajors(college);
        return ResultVOUtil.succeed(schoolcollegesVo);
    }
}

package com.socialapppro.controller;


import com.socialapppro.VO.ResultVO;
import com.socialapppro.domain.entity.Colleges;
import com.socialapppro.service.SchoolcollegesService;
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
 * @author admin
 * @since 2024-03-27
 */
@RestController
@RequestMapping("/schoolcolleges")
public class SchoolcollegesController {
    @Autowired
    SchoolcollegesService schoolcollegesService;

    @GetMapping("/getcolleges/{school}")
    public ResultVO getcolleges(@PathVariable("school") String school){
        List<Colleges> schoolcollegesVo = schoolcollegesService.getcolleges(school);
        return ResultVOUtil.succeed(schoolcollegesVo);
    }
}


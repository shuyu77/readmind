package com.socialapppro.controller;


import com.socialapppro.VO.ResultVO;
import com.socialapppro.domain.entity.Schools;
import com.socialapppro.service.SchoolsService;
import com.socialapppro.util.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/schools")
public class SchoolsController {
    @Autowired
    SchoolsService schoolsService;

    @GetMapping("/getAll")
    private ResultVO getAll(){
        List<Schools> schools = schoolsService.list();
        return ResultVOUtil.succeed(schools);
    }

    @PostMapping("/add")
    public ResultVO add(@RequestBody Schools schools) {
        schoolsService.add(schools);
        return ResultVO.success();
    }
    @DeleteMapping("/deleteById/{id}")
    public ResultVO deleteById(@PathVariable("id")Integer id){
        boolean remove=this.schoolsService.removeById(id);
        if(!remove){
            return ResultVOUtil.fail();
        }
        else{
            return ResultVOUtil.success(null);
        }
    }
    @GetMapping("/list")
    public ResultVO<List<Schools>> list(){
        List<Schools> schools = schoolsService.list();
        return ResultVO.success(schools);
    }

    @PutMapping("/update")
    public ResultVO update(@RequestBody Schools schools){
        schoolsService.update(schools);
        return ResultVO.success();
    }
}


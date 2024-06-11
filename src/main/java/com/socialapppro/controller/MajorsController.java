package com.socialapppro.controller;


import com.socialapppro.VO.PageBean;
import com.socialapppro.VO.ResultVO;
import com.socialapppro.domain.entity.Majors;
import com.socialapppro.service.MajorsService;
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
@RequestMapping("/majors")
public class MajorsController {
    @Autowired
    private MajorsService majorsService;
    @PostMapping("/add")
    public ResultVO add(@RequestBody Majors majors) {
        majorsService.add(majors);
        return ResultVO.success();
    }
    @DeleteMapping("/deleteById/{id}")
    public ResultVO deleteById(@PathVariable("id")Integer id){
        boolean remove=this.majorsService.removeById(id);
        if(!remove){
            return ResultVOUtil.fail();
        }
        else{
            return ResultVOUtil.success(null);
        }
    }
    @GetMapping("/getAll")
    public ResultVO<List<Majors>> getAll(){
        List<Majors> majors = majorsService.list();
        return ResultVO.success(majors);
    }

    @PutMapping("/update")
    public ResultVO update(@RequestBody Majors majors){
        majorsService.update(majors);
        return ResultVO.success();
    }
    @GetMapping("/list")
    public ResultVO<PageBean<Majors>>list (@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam(required = false)String collegeId){
        PageBean<Majors>pageBean=majorsService.list(pageNum,pageSize,collegeId);
        return ResultVO.success(pageBean);
    }
    @GetMapping("/listConfirm/{collegeId}")
    public ResultVO listConfirm (@PathVariable("collegeId")String collegeId){
        List<Majors> majors=majorsService.listConfirm(collegeId);
        return ResultVOUtil.succeed(majors);
    }

}


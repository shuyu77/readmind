package com.socialapppro.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.socialapppro.VO.PageBean;
import com.socialapppro.VO.PageVO;
import com.socialapppro.VO.ResultVO;
import com.socialapppro.domain.entity.Colleges;
import com.socialapppro.domain.entity.Users;
import com.socialapppro.form.SearchForm;
import com.socialapppro.service.CollegesService;
import com.socialapppro.util.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

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
@RequestMapping("/colleges")
public class CollegesController {
    @Autowired
    CollegesService collegesService;

    @GetMapping("/getAll")
    public ResultVO getAll(){
        List<Colleges> colleges = collegesService.list();
        return ResultVOUtil.succeed(colleges);
    }
    @PostMapping("/add")
    public ResultVO add(@RequestBody Colleges colleges) {
        collegesService.add(colleges);
        return ResultVO.success();
    }
    @DeleteMapping("/deleteById/{id}")
    public ResultVO deleteById(@PathVariable("id")Integer id){
        boolean remove=this.collegesService.removeById(id);
        if(!remove){
            return ResultVOUtil.fail();
        }
        else{
            return ResultVOUtil.success(null);
        }
    }
//    @GetMapping("/search")
//    public ResultVO search(SearchForm searchForm){
//        PageVO pageVO=this.collegesService.search(searchForm);
//        return ResultVOUtil.success(pageVO);
//    }
//    @GetMapping("/lists/{id}")
//    public ResultVO lists(@PathVariable("id") String id){
//        QueryWrapper<Users> queryWrapper=new QueryWrapper<>();
//        queryWrapper.eq("admin_id",id);
//        Users users=this.collegesService.selectOne(queryWrapper);
//        return ResultVOUtil.success(users);
//    }
//@GetMapping("/list")
//public ResultVO<List<Colleges>> list(){
//    List<Colleges> cs = collegesService.list();
//    return ResultVO.success(cs);
//}
    @GetMapping("/detail")
    public ResultVO<Colleges> detail(Integer id){
        Colleges colleges = collegesService.findById(id);
        return ResultVO.success(colleges);
    }

    @PutMapping("/update")
    public ResultVO update(@RequestBody Colleges colleges){
        collegesService.update(colleges);
        return ResultVO.success();
    }

    @GetMapping("/list")
    public ResultVO<PageBean<Colleges>>list (@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam(required = false)String schoolId){
        PageBean<Colleges>pageBean=collegesService.list(pageNum,pageSize,schoolId);
        return ResultVO.success(pageBean);
    }
    @GetMapping("/listConfirm/{schoolId}")
    public ResultVO listConfirm (@PathVariable("schoolId")String schoolId){
        List<Colleges> colleges=collegesService.listConfirm(schoolId);
        return ResultVOUtil.succeed(colleges);
    }

}


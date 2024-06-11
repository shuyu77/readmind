package com.socialapppro.controller;


import com.socialapppro.VO.ResultVO;
import com.socialapppro.domain.entity.Tags;
import com.socialapppro.domain.entity.Tags;
import com.socialapppro.service.TagsService;
import com.socialapppro.util.ResultVOUtil;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
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
@RequestMapping("/tags")
public class TagsController {
    @Autowired
    TagsService tagsService;

    @GetMapping("/getAll")
    public ResultVO getAll(){
        List<Tags> tags = tagsService.list();
        return ResultVOUtil.succeed(tags);
    }

    @PostMapping("/add")
    public ResultVO add(@RequestBody Tags tags) {
        tagsService.add(tags);
        return ResultVO.success();
    }
    @DeleteMapping("/deleteById/{id}")
    public ResultVO deleteById(@PathVariable("id")Integer tagId){
        boolean remove=this.tagsService.removeById(tagId);
        if(!remove){
            return ResultVOUtil.fail();
        }
        else{
            return ResultVOUtil.success(null);
        }
    }
    @GetMapping("/findByName")
    public ResultVO findByName(Integer name){
        List<Tags> tags = tagsService.findByName(name);
        return ResultVO.success(tags);
    }

}


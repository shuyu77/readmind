package com.socialapppro.controller;


import com.socialapppro.VO.ResultVO;
import com.socialapppro.domain.entity.Pictures;
import com.socialapppro.service.PicturesService;
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
 * @since 2024-04-07
 */
@RestController
@RequestMapping("/pictures")
public class PicturesController {
    @Autowired
    PicturesService picturesService;

    @GetMapping("/getImageBypostId/{postId}")
    public ResultVO getImageBypostId(@PathVariable("postId")Integer postId){
        List<Pictures> picturesList = picturesService.getImageBypostId(postId);
        return ResultVOUtil.succeed(picturesList);
    }



}

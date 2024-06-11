package com.socialapppro.controller;


import com.socialapppro.VO.ResultVO;
import com.socialapppro.domain.entity.Posts;
import com.socialapppro.service.PostTagsService;
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
@RequestMapping("/postTags")
public class PostTagsController {
    @Autowired
    PostTagsService postTagsService;

    @GetMapping("/getPost/{tapId}")
    public ResultVO getPost(@PathVariable("tapId") Integer tapId){
        List<Posts> postsList = postTagsService.getAll(tapId);
        return ResultVOUtil.succeed(postsList);
    }
}


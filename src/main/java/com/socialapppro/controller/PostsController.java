package com.socialapppro.controller;


import com.alibaba.fastjson.JSONObject;
import com.socialapppro.VO.ResultVO;
import com.socialapppro.domain.dto.ArticleDTO;
import com.socialapppro.domain.entity.Posts;
import com.socialapppro.service.PostsService;
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
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    PostsService postsService;

    @GetMapping("/getPostAll")
    public ResultVO getPostAll(){
        List<Posts> postsList = postsService.getPostAll();
        return ResultVOUtil.succeed(postsList);
    }

    @GetMapping("/getPostAllMyUserId/{userId}")
    public ResultVO getPostAllMyUserId(@PathVariable("userId")Integer userId){
        List<Posts> postsList = postsService.getPostAllMyUserId(userId);
        return ResultVOUtil.succeed(postsList);
    }


    @GetMapping("/getPostsById/{postId}")
    public ResultVO getPostsById(@PathVariable("postId")Integer postId){
        ArticleDTO articleDTO = postsService.getPostsById(postId);
        return ResultVOUtil.succeed(articleDTO);
    }

    @PostMapping("/addPost")
    public ResultVO addPost(@RequestBody JSONObject obj){
        if(postsService.addPost(obj)){
            return ResultVOUtil.succeed(null);
        }
        return ResultVOUtil.fail();
    }

    @GetMapping("/deletePostById/{postId}")
    public ResultVO deletePostById(@PathVariable("postId") Integer postId){
        if(postsService.removeById(postId)){
            return ResultVOUtil.succeed(null);
        }
        return ResultVOUtil.fail();
    }

    @GetMapping("/getNewActivity")
    public ResultVO getNewActivity(){
        List<Posts> postList = postsService.getNewActivity();
        return ResultVOUtil.succeed(postList);
    }

    @GetMapping("/getPostByUserId/{userId}")
    public ResultVO getPostByUserId(@PathVariable("userId")Integer userId){
        if(userId == null) return ResultVOUtil.fail();
        List<Posts> postsList = postsService.getPostByUserId(userId);
        return ResultVOUtil.succeed(postsList);
    }
}


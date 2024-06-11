package com.socialapppro.controller;


import com.socialapppro.VO.ResultVO;
import com.socialapppro.domain.entity.Likes;
import com.socialapppro.service.LikesService;
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
@RequestMapping("/likes")
public class LikesController {
    @Autowired
    private LikesService likesService;


    @GetMapping("/likesByPostId/{postId}")
    public ResultVO likesByPostId(@PathVariable("postId") Integer postId){
        Long likesCount = likesService.likesByPostId(postId);
        return ResultVOUtil.succeed(likesCount);
    }

    @GetMapping("/getlikesByPostId/{postId}/{userId}")
    public ResultVO getlikesByPostId(@PathVariable("postId") Integer postId, @PathVariable("userId") Integer userId){
        if(likesService.getlikesByPostId(postId, userId)){
            return ResultVOUtil.succeed(null);
        }
        return ResultVOUtil.fail();
    }

    @GetMapping("/addlikesByPostId/{postId}/{userId}")
    public ResultVO addlikesByPostId(@PathVariable("postId") Integer postId, @PathVariable("userId") Integer userId){;
        if(likesService.addlikesByPostId(postId, userId)){
            likesService.updatePostLikes(postId);
            return ResultVOUtil.succeed(null);
        }
        return ResultVOUtil.servererror(null);
    }

    @GetMapping("/deletelikesByPostId/{postId}/{userId}")
    public ResultVO deletelikesByPostId(@PathVariable("postId") Integer postId, @PathVariable("userId") Integer userId){
        if(likesService.deletelikesByPostId(postId, userId)){
            likesService.updatePostLikes(postId);
            return ResultVOUtil.succeed(null);
        }
        return ResultVOUtil.servererror(null);
    }

    @GetMapping("/getLikedPostByUserId/{userId}")
    public ResultVO getLikedPostByUserId(@PathVariable("userId") Integer userId){
        if(userId != null){
            List<Likes> likesList = likesService.getLikedPostByUserId(userId);
            return ResultVOUtil.succeed(likesList);
        }
        return ResultVOUtil.servererror(null);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResultVO deleteById(@PathVariable("id")Integer likeId){
        boolean remove=this.likesService.removeById(likeId);
        if(!remove){
            return ResultVOUtil.fail();
        }
        else{
            return ResultVOUtil.success(null);
        }
    }
    @GetMapping("/list")
    public ResultVO<List<Likes>> list(){
        List<Likes> likes = likesService.list();
        return ResultVO.success(likes);
    }
    @GetMapping("/findByuserId/{id}")
    public ResultVO<List<Likes>> findByuserId(Integer userId){
        List<Likes> likes = likesService.findByuserId(userId);
        return ResultVO.success(likes);
    }

    @GetMapping("/ListByUserId/{userId}")
    public ResultVO ListByUserId(@PathVariable("userId") Integer userId){
        if(userId != null){
            return ResultVOUtil.succeed(likesService.ListByUserId(userId));
        }
        return ResultVOUtil.fail();
    }
}


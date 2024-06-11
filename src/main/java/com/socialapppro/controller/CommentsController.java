package com.socialapppro.controller;


import com.socialapppro.VO.ResultVO;
import com.socialapppro.domain.entity.Comments;
import com.socialapppro.service.CommentsService;
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
@RequestMapping("/comments")
public class CommentsController {
    @Autowired
    CommentsService commentsService;

    @GetMapping("/getCommentsBypostId/{postId}")
    public ResultVO getCommentsBypostId(@PathVariable("postId")Integer postId){
        List<Comments> commentsList = commentsService.getCommentsBypostId(postId);
        return ResultVOUtil.succeed(commentsList);
    }

    @PostMapping("/addComments")
    public ResultVO addComments(@RequestBody Comments comments){
        commentsService.save(comments);
        commentsService.updatePostcomment(comments.getPostId());
        return ResultVOUtil.succeed(null);
    }

    @GetMapping("/deletecommentById/{commentId}")
    public ResultVO deletecommentById(@PathVariable("commentId")Integer commentId){
        Comments comments = commentsService.getById(commentId);
        if(commentsService.removeById(commentId)){
            commentsService.updatePostcomment(comments.getPostId());
            return ResultVOUtil.succeed(null);
        }
        return ResultVOUtil.servererror(null);
    }

    @PostMapping("/add")
    public ResultVO add(@RequestBody Comments comments) {
        commentsService.add(comments);
        return ResultVO.success();
    }
    @DeleteMapping("/deleteById/{id}")
    public ResultVO deleteById(@PathVariable("id")Integer id){
        boolean remove=this.commentsService.removeById(id);
        if(!remove){
            return ResultVOUtil.fail();
        }
        else{
            return ResultVOUtil.success(null);
        }
    }
    @GetMapping("/list")
    public ResultVO<List<Comments>> list(){
        List<Comments> comments = commentsService.list();
        return ResultVO.success(comments);
    }
    @GetMapping("/detail/{userId}")
    public ResultVO<Comments> detail( @PathVariable("userId") Integer userId){
        Comments comments = commentsService.findByUserId(userId);
        return ResultVO.success(comments);
    }

    @PutMapping("/update")
    public ResultVO update(@RequestBody Comments comments){
        commentsService.update(comments);
        return ResultVO.success();
    }

    @GetMapping("/ListMyComment/{userId}")
    public ResultVO ListMyComment(@PathVariable("userId")Integer userId){
        if(userId != null){
            return ResultVOUtil.succeed(commentsService.ListMyComment(userId));
        }
        return ResultVOUtil.fail();
    }
}


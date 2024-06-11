package com.socialapppro.controller;


import com.socialapppro.VO.ResultVO;
import com.socialapppro.domain.entity.Follows;
import com.socialapppro.service.FollowsService;
import com.socialapppro.util.ResultVOUtil;
import io.swagger.models.auth.In;
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
@RequestMapping("/follows")
public class FollowsController {

    @Autowired
    private FollowsService followsService;

    @PostMapping("/add")
    public ResultVO add(@RequestBody Follows follows) {
        followsService.add(follows);
        return ResultVO.success();
    }
    @DeleteMapping("/deleteById/{id}")
    public ResultVO deleteById(@PathVariable("id")Integer followsId){
        boolean remove=this.followsService.removeById(followsId);
        if(!remove){
            return ResultVOUtil.fail();
        }
        else{
            return ResultVOUtil.success(null);
        }
    }
    @GetMapping("/list")
    public ResultVO<List<Follows>> list(){
        List<Follows> follows = followsService.list();
        return ResultVO.success(follows);
    }
    @GetMapping("/findByfollowerId/{followerId}")
    public ResultVO<List<Follows>> findByfollowerId( @PathVariable("followerId")Integer followerId){
        List<Follows> follows = followsService.findByfollowerId(followerId);
        return ResultVO.success(follows);
    }
    @GetMapping("/findByfolloweeId/{followeeId}")
    public ResultVO<List<Follows>> findByfolloweeId( @PathVariable("followeeId") Integer followeeId){
        List<Follows> follows = followsService.findByfolloweeId(followeeId);
        return ResultVO.success(follows);
    }

    @PutMapping("/update")
    public ResultVO update(@RequestBody Follows follows){
        followsService.update(follows);
        return ResultVO.success();
    }

    @GetMapping("/getfollowState/{follower}/{followee}")
    public  ResultVO getfollowState(@PathVariable("follower")Integer follower, @PathVariable("followee")Integer followee){
        if(followsService.getfollowState(follower, followee)){
            return ResultVOUtil.succeed(null);
        }
        return ResultVOUtil.fail();
    }

    @GetMapping("/changefollowState/{follower}/{followee}/{state}")
    public ResultVO changefollowState(@PathVariable("follower")Integer follower, @PathVariable("followee")Integer followee, @PathVariable("state")Boolean state){
        if(!state){
            Follows follows = new Follows();
            follows.setFolloweeId(followee);
            follows.setFollowerId(follower);
            followsService.add(follows);
            return ResultVOUtil.succeed(null);
        }
        else{
            followsService.delete(follower, followee);
            return ResultVOUtil.succeed(null);
        }
    }

    @GetMapping("/ListFollowByUserId/{followee}")
    public ResultVO ListFollowByUserId(@PathVariable("followee")Integer followee){

        return ResultVOUtil.succeed(followsService.ListFollowByUserId(followee));
    }
}


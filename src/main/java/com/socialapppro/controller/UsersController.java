package com.socialapppro.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.socialapppro.VO.PageVO;
import com.socialapppro.VO.ResultVO;
import com.socialapppro.domain.entity.Users;
import com.socialapppro.form.SearchForm;
import com.socialapppro.service.UsersService;
import com.socialapppro.util.ResultVOUtil;
import com.socialapppro.util.WechatUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @Bean
    public WechatUtils wechatUtils() {
        return new WechatUtils();
    }

    @GetMapping("/getAll")
    public ResultVO<List<Users>> getAll(){
        List<Users> users = usersService.getAll();
        return ResultVO.success(users);
    }

    @GetMapping("/getUser/{userId}")
    public ResultVO getUser(@PathVariable("userId")Integer id){
        if(id == null) return ResultVOUtil.clienterror(null);
        Users user = usersService.getUserWithSchoolAndCollegesAndMajor(id);
        if(user == null) return ResultVOUtil.servererror(user);
        return ResultVOUtil.succeed(user);
    }
    @PostMapping("/login")
    public ResultVO login(@RequestBody JSONObject obj){
        String code = obj.getString("code");
        if(code == null){
//            是否有code
            return ResultVOUtil.clienterror(null);
        }
        JSONObject wxJson = JSONObject.parseObject(WechatUtils.getOpenid(code));
        System.out.println("微信的返回值{}" + wxJson);
        Users user = usersService.getOpenid(wxJson.getString("openid"));
        if(user == null){
//            注册
            user = new Users();
            user.setAccount(wxJson.getString("openid"));
            user.setSessionKey(wxJson.getString("session_key"));
            user.setUsername(obj.getString("name"));
            user.setPicture(obj.getString("picture"));
            usersService.save(user);
        }
        else{
//            登入
            user.setSessionKey(wxJson.getString("session_key"));
            user.setUsername(obj.getString("username"));
            user.setPicture(obj.getString("picture"));
            usersService.updateById(user);
        }
//        获取id
        user = usersService.getOpenid(wxJson.getString("openid"));
//        获取学院等数据
        user = usersService.getUserWithSchoolAndCollegesAndMajor(user.getUserId());
        user.setAccount(null);
        //        使用MD5加密并返回
        user.setSessionKey(DigestUtils.md5Hex(wxJson.getString("session_key")));
        return  ResultVOUtil.succeed(user);
    }

    @PostMapping("/introduction")
    public ResultVO introduction(@RequestBody Users users){
        Users newuser = new Users();
        newuser.setUserId(users.getUserId());
        newuser.setIntroduction(users.getIntroduction());
        if(usersService.updateById(newuser)){
            return ResultVOUtil.succeed(null);
        }
        else{
            return ResultVOUtil.clienterror(null);
        }
    }

    @PostMapping("/school")
    public  ResultVO postSchool(@RequestBody Users users){
        users.setSchoolId(users.getSchools().getSchoolId());
        users.setCollegeId(users.getColleges().getCollegeId());
        users.setMajorId(users.getMajors().getMajorId());
        if(usersService.postSchool(users)){
            return ResultVOUtil.succeed(null);
        }
        else{
            return ResultVOUtil.clienterror(null);
        }
    }
    @PostMapping("/add")
    public ResultVO add(@RequestBody Users users) {
        usersService.add(users);
        return ResultVO.success();
    }
    @DeleteMapping("/deleteById/{id}")
    public ResultVO deleteById(@PathVariable("id")Integer id){
        boolean remove=this.usersService.removeById(id);
        if(!remove){
            return ResultVOUtil.fail();
        }
        else{
            return ResultVOUtil.success(null);
        }
    }
    @GetMapping("/search")
    public ResultVO search(SearchForm searchForm){
        PageVO pageVO=this.usersService.search(searchForm);
        return ResultVOUtil.success(pageVO);
    }
    @GetMapping("/lists/{id}")
    public ResultVO lists(@PathVariable("id") String id){
        QueryWrapper<Users> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("admin_id",id);
        Users users=this.usersService.selectOne(queryWrapper);
        return ResultVOUtil.success(users);
    }
    @PutMapping("/update")
    public ResultVO update(@RequestBody Users users){
        usersService.update(users);
        return ResultVO.success();
    }


}


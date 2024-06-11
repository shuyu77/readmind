package com.socialapppro.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.socialapppro.VO.PageVO;
import com.socialapppro.VO.ResultVO;
import com.socialapppro.domain.entity.Managers;
import com.socialapppro.form.RuleForm;
import com.socialapppro.form.SearchForm;
import com.socialapppro.mapper.ManagersMapper;
import com.socialapppro.service.ManagersService;
import com.socialapppro.util.Md5Util;
import com.socialapppro.util.ResultVOUtil;
import com.socialapppro.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2024-03-24
 */
@RestController
@RequestMapping("/managers")
public class ManagersController {
    @Autowired
    private ManagersService managersService;
    @Autowired
    private ManagersMapper managersMapper;

    @PostMapping("/login")
    public ResultVO login(RuleForm ruleForm){
        ResultVO resultVO=this.managersService.login(ruleForm);
        return resultVO;
    }
    @GetMapping("/search")
    public ResultVO search(SearchForm searchForm){
        PageVO pageVO=this.managersService.search(searchForm);
        return ResultVOUtil.success(pageVO);
    }
    @GetMapping("/lists/{id}")
    public ResultVO lists(@PathVariable("id") String id){
        QueryWrapper<Managers> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("admin_id",id);
        Managers managers=this.managersMapper.selectOne(queryWrapper);
        return ResultVOUtil.success(managers);
    }
    @PostMapping("/save")//添加
    public ResultVO save(@RequestBody Managers managers){
        boolean save = this.managersService.save(managers);
        if(!save){
            return ResultVOUtil.fail();
        }
        else{
            return ResultVOUtil.success(null);
        }
    }
    @DeleteMapping("/deleteById/{id}")
    public ResultVO deleteById(@PathVariable("id")Integer id){
        boolean remove=this.managersService.removeById(id);
        if(!remove){
            return ResultVOUtil.fail();
        }
        else{
            return ResultVOUtil.success(null);
        }
    }
    @GetMapping("/findById/{id}")
    public ResultVO findById(@PathVariable("id")Integer id){
        Managers managers=this.managersService.getById(id);
        return ResultVOUtil.success(managers);
    }

    @GetMapping("/info")
    public ResultVO<Managers> userInfo(){
//        @RequestHeader(name = "Authorization")String token
//        Map<String,Object> map=JwtUtil.parseToken(token);
//        String username=(String) map.get("username");
        Map<String,Object>map= ThreadLocalUtil.get();
        String username= (String) map.get("username");
        Managers manager= managersService.findByManagerName(username);
        return ResultVO.success(manager);
    }

//    @PutMapping("/update")
//    public ResultVO update(@RequestBody Managers managers){
//        boolean update=this.managersService.updateById(managers);
//        if(!update){
//            return ResultVOUtil.fail();
//        }
//        else{
//            return ResultVOUtil.success(null);
//        }
//    }

    @PutMapping("/update")
    public ResultVO update(@RequestBody Managers managers){
        managersService.update(managers);
        return ResultVO.success();
    }

    @PatchMapping("updatePwd")
    public ResultVO updatePwd(@RequestBody Map<String,String>params){
        String oldPwd=params.get("old_pwd");
        String newPwd=params.get("new_pwd");
        String rePwd=params.get("re_pwd");
        if (StringUtils.isEmpty(oldPwd)||StringUtils.isEmpty(newPwd)||StringUtils.isEmpty(rePwd)){
            return ResultVO.error();
        }
        //原密码是否正确
        //调用userService根据用户名拿到原密码,再和old_pwd比对
        Map<String,Object> map = ThreadLocalUtil.get();
        System.out.println();
        String username = (String) map.get("username");
        Managers loginUser = managersService.findByManagerName(username);
        if (!loginUser.getPassword().equals(Md5Util.getMD5String(oldPwd))){
            System.out.println(Md5Util.getMD5String(oldPwd));
            return ResultVO.error();
        }

        //newPwd和rePwd是否一样
        if (!rePwd.equals(newPwd)){
            return ResultVO.error();
        }
        //2.调用service完成密码更新
        managersService.updatePwd(newPwd);
        //删除redis中对应的token
//        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
//        operations.getOperations().delete(token);
        return ResultVO.success();
    }
}
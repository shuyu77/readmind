package com.socialapppro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.socialapppro.VO.PageVO;
import com.socialapppro.VO.ResultVO;
import com.socialapppro.domain.entity.Managers;
import com.socialapppro.form.RuleForm;
import com.socialapppro.form.SearchForm;
import com.socialapppro.mapper.ManagersMapper;
import com.socialapppro.service.ManagersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.socialapppro.util.JwtUtil;
import com.socialapppro.util.Md5Util;
import com.socialapppro.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2024-03-27
 */
@Service
public class ManagersServiceImpl extends ServiceImpl<ManagersMapper, Managers> implements ManagersService {

    @Autowired
    ManagersMapper managersMapper;
    public ResultVO login(RuleForm ruleForm){
//        账号2密码adminpass2
        System.out.println(Md5Util.getMD5String(ruleForm.getPassword()));

        //判断用户是否存在
        QueryWrapper<Managers> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("admin_id",ruleForm.getUserid());
        Managers managers=this.managersMapper.selectOne(queryWrapper);
        if(managers==null){
            return ResultVO.error();
        }
        if(Md5Util.getMD5String(ruleForm.getPassword()).equals(managers.getPassword())){
            System.out.println("aa");
            Map<String,Object>claims=new HashMap<>();
            claims.put("adminId",managers.getAdminId());
            claims.put("username",managers.getUsername());
            String token= JwtUtil.genToken(claims);
            return ResultVO.success(token);
        }
        return ResultVO.error();
    }
    @Override
    public PageVO search(SearchForm searchForm){
        Page<Managers> managersPage=new Page<>(searchForm.getPage(),searchForm.getSize());
        Page<Managers> resultPage=null;
        if(searchForm.getValue().equals("")){
            resultPage = this.managersMapper.selectPage(managersPage, null);
        }
        else{
            QueryWrapper<Managers> queryWrapper=new QueryWrapper<>();
            queryWrapper.like(searchForm.getKey(),searchForm.getValue());
            resultPage = this.managersMapper.selectPage(managersPage, queryWrapper);
        }
        PageVO pageVO=new PageVO();
        pageVO.setTotal(resultPage.getTotal());
        pageVO.setData(resultPage.getRecords());
        return pageVO;
    }

    @Override
    public PageVO list(Integer page,Integer size){
        Page<Managers> managersPage=new Page<>(page,size);
        Page<Managers> resultPage = this.managersMapper.selectPage(managersPage, null);
        PageVO pageVO=new PageVO();
        pageVO.setTotal(resultPage.getTotal());
        pageVO.setData(resultPage.getRecords());
        return pageVO;
    }

    @Override
    public Managers findByManagerName(String username) {
        QueryWrapper<Managers> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",username);
    return managersMapper.selectOne(queryWrapper);
    }

    @Override
    public void update(Managers managers) {
        managers.setUpdatedAt(LocalDateTime.now());
        managersMapper.update(managers);
    }

    @Override
    public void updatePwd(String newPwd) {
        Map<String,Object>map= ThreadLocalUtil.get();
        System.out.println(map);
        Integer adminId=(Integer)map.get("adminId");
        System.out.println(adminId);
        managersMapper.updatePwd(Md5Util.getMD5String(newPwd),adminId);
    }
}

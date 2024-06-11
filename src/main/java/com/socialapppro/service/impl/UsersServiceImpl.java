package com.socialapppro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.socialapppro.VO.PageVO;
import com.socialapppro.domain.entity.Users;
import com.socialapppro.form.SearchForm;
import com.socialapppro.mapper.UsersMapper;
import com.socialapppro.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2024-03-27
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

    @Autowired
    UsersMapper usersMapper;

    @Override
    public Users getOpenid(String openid) {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", openid);
        return usersMapper.selectOne(queryWrapper);
    }

    @Override
    public Users getUserWithSchoolAndCollegesAndMajor(Integer userId) {
        return usersMapper.getUserWithSchoolAndCollegesAndMajor(userId);
    }

    @Override
    public boolean postSchool(Users users) {
        UpdateWrapper<Users> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("user_id",users.getUserId());
        return usersMapper.update(users, updateWrapper) != 0;
    }
    @Override
    public void add(Users users) {
        //补充属性值
        users.setCreatedAt(LocalDateTime.now());
        users.setUpdatedAt(LocalDateTime.now());
        usersMapper.add(users);
    }

    @Override
    public PageVO search(SearchForm searchForm){
        Page<Users> usersPage=new Page<>(searchForm.getPage(),searchForm.getSize());
        Page<Users> resultPage=null;
        if(searchForm.getValue().equals("")){
            resultPage = this.usersMapper.selectPage(usersPage, null);
        }
        else{
            QueryWrapper<Users> queryWrapper=new QueryWrapper<>();
            queryWrapper.like(searchForm.getKey(),searchForm.getValue());
            resultPage = this.usersMapper.selectPage(usersPage, queryWrapper);
        }
        PageVO pageVO=new PageVO();
        pageVO.setTotal(resultPage.getTotal());
        pageVO.setData(resultPage.getRecords());
        return pageVO;
    }

    @Override
    public Users selectOne(QueryWrapper<Users> queryWrapper) {
        return usersMapper.selectOne(queryWrapper);
    }

    @Override
    public void update(Users users) {
        users.setUpdatedAt(LocalDateTime.now());
        usersMapper.update(users);
    }

    @Override
    public List<Users> getAll() {
        return usersMapper.getAll();
    }

//    @Override
//    public List<Users> getAll() {
//        return null;
//    }


}

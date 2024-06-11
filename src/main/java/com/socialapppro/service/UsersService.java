package com.socialapppro.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.socialapppro.VO.PageVO;
import com.socialapppro.domain.entity.Users;
import com.socialapppro.form.SearchForm;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2024-03-27
 */
public interface UsersService extends IService<Users> {

    Users getOpenid(String openid);

    Users getUserWithSchoolAndCollegesAndMajor(Integer userId);

    boolean postSchool(Users users);

    void add(Users users);

    PageVO search(SearchForm searchForm);

    Users selectOne(QueryWrapper<Users> queryWrapper);

    void update(Users users);

    List<Users> getAll();
}

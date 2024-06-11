package com.socialapppro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.socialapppro.domain.dto.FollowsDTO;
import com.socialapppro.domain.entity.Follows;
import com.socialapppro.mapper.FollowsMapper;
import com.socialapppro.service.FollowsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class FollowsServiceImpl extends ServiceImpl<FollowsMapper, Follows> implements FollowsService {

    @Autowired
    private FollowsMapper followsMapper;
    @Override
    public void add(Follows follows) {
        followsMapper.add(follows);
    }

    @Override
    public List<Follows> findByfollowerId(Integer followerId) {
        return (List<Follows>) followsMapper.findByfollwerId();
    }


    @Override
    public List<Follows> findByfolloweeId(Integer followeeId) {
        return (List<Follows>) followsMapper.findByfollweeId();
    }

    @Override
    public void update(Follows follows) {

    }

    @Override
    public boolean getfollowState(Integer follower, Integer followee) {
        QueryWrapper<Follows> wrapper = new QueryWrapper<>();
        wrapper.eq("follower_id", follower);
        wrapper.eq("followee_id",followee);
        return followsMapper.selectOne(wrapper) != null;
    }

    @Override
    public void delete(Integer follower, Integer followee) {
        QueryWrapper<Follows> wrapper = new QueryWrapper<>();
        wrapper.eq("follower_id", follower);
        wrapper.eq("followee_id",followee);
        followsMapper.delete(wrapper);
    }

    @Override
    public Object ListFollowByUserId(Integer followee) {
        List<FollowsDTO> followsDTOList = followsMapper.ListFollowByUserId(followee);
        return followsDTOList;
    }
}

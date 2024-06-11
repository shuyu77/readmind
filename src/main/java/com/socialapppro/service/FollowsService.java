package com.socialapppro.service;

import com.socialapppro.domain.entity.Follows;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author admin
 * @since 2024-03-27
 */
public interface FollowsService extends IService<Follows> {


    void add(Follows follows);

    List<Follows> findByfollowerId(Integer followerId);

    List<Follows> findByfolloweeId(Integer followeeId);

    void update(Follows follows);

    boolean getfollowState(Integer follower, Integer followee);

    void delete(Integer follower, Integer followee);

    Object ListFollowByUserId(Integer followee);
}

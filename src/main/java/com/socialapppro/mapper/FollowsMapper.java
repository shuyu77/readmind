package com.socialapppro.mapper;

import com.socialapppro.domain.dto.FollowsDTO;
import com.socialapppro.domain.entity.Comments;
import com.socialapppro.domain.entity.Follows;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2024-03-27
 */
public interface FollowsMapper extends BaseMapper<Follows> {
    @Insert("insert into follows(follower_id,followee_id,follow_status) values (#{followerId},#{followeeId},#{followStatus})")
    void add(Follows follows);

    @Update("update comments set user_id,post_id,content=#{userId},#{postId},#{content} where college_id=#{collegeId}")
    void update(Comments comments);
    @Select("select * from follows where follower_id = #{followerId}")
    Follows findByfollwerId();
    @Select("select * from follows where followee_id = #{followeeId}")
    Follows findByfollweeId();
    @Select("SELECT f.*, u.username, u.picture, u.introduction FROM follows f " +
            "JOIN users u ON f.follower_id = u.user_id " +
            "WHERE f.followee_id = #{followee} " +
            "ORDER BY f.created_at DESC ")
    List<FollowsDTO> ListFollowByUserId(Integer followee);
}

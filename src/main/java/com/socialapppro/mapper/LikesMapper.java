package com.socialapppro.mapper;

import com.socialapppro.domain.dto.LikeDTO;
import com.socialapppro.domain.entity.Likes;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2024-03-27
 */
public interface LikesMapper extends BaseMapper<Likes> {
    @Select("SELECT l.*, u.username, u.picture, u.introduction, p.images FROM likes l " +
            "JOIN users u ON l.user_id = u.user_id " +
            "JOIN posts p ON l.post_id = p.post_id " +
            "WHERE l.post_id = #{postId} ")
    List<LikeDTO> ListByUserId(Integer postId);

}

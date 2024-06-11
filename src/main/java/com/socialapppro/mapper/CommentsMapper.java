package com.socialapppro.mapper;

import com.socialapppro.domain.dto.CommentDTO;
import com.socialapppro.domain.dto.LikeDTO;
import com.socialapppro.domain.entity.Comments;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2024-03-27
 */
public interface CommentsMapper extends BaseMapper<Comments> {

    @Results({
            @Result(column = "name", property = "name", javaType = String.class)
    })
    @Select("SELECT c.*, u.picture, u.username FROM comments c " +
            "JOIN users u ON c.user_id = u.user_id " +
            "WHERE c.post_id = #{postId} " +
            "ORDER BY c.created_at DESC; ")
    List<Comments> getCommentsBypostId(Integer postId);
    @Insert("insert into comments(user_id,post_id,content) values (#{userId},#{postId},#{content})")
    void add(Comments comments);
    @Select("select * from comments where user_id = #{userId}")
    Comments findByUserId(Integer id);
    @Update("update comments set user_id=#{userId},post_id=#{postId},content=#{content} where comment_id=#{commentId}")
    void update(Comments comments);

    @Select("SELECT c.*, u.username, u.picture, u.introduction, p.images FROM comments c " +
            "JOIN users u ON c.user_id = u.user_id " +
            "JOIN posts p ON c.post_id = p.post_id " +
            "WHERE c.post_id = #{postId} ")
    List<CommentDTO> ListMyComment(Integer postId);
}

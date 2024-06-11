package com.socialapppro.mapper;

import com.socialapppro.domain.dto.ArticleDTO;
import com.socialapppro.domain.entity.Posts;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
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
public interface PostsMapper extends BaseMapper<Posts> {


    @Select("SELECT p.*, u.username, u.picture FROM posts p " +
            "JOIN users u ON p.user_id = u.user_id " +
            "ORDER BY p.created_at DESC ")
    List<Posts> getPostAll();

    @Select("SELECT p.*, u.username FROM posts p " +
            "JOIN users u ON p.user_id = u.user_id " +
            "ORDER BY p.created_at DESC " +
            "LIMIT 10;")
    List<Posts> getNewActivity();

    @Select("SELECT p.*, u.username, u.picture FROM posts p " +
            "JOIN users u ON p.user_id = u.user_id " +
            "WHERE p.user_id = #{userId}")
    List<Posts> getPostByUserId(Integer userId);

    @Select("SELECT p.*, u.username, u.picture, u.introduction FROM posts p " +
            "JOIN users u ON p.user_id = u.user_id " +
            "WHERE p.post_id = #{postId} ")
    ArticleDTO getPostsById(Integer postId);

    @Insert("insert into posts(user_id,title,content,images,likes_count,comments_count,created_at,updated_at) " +
            "values(#{userId},#{title},#{content},#{images},#{likes},#{count},#{commentsCount},#{createdAt},#{updatedAt})")
    void add(Posts posts);

    @Select("SELECT p.*, u.username, u.picture FROM posts p " +
            "JOIN users u ON p.user_id = u.user_id " +
            "WHERE p.user_id != #{userId} " +
            "ORDER BY p.created_at DESC ")
    List<Posts> getPostAllMyUserId(Integer userId);
}

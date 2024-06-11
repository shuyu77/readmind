package com.socialapppro.mapper;

import com.socialapppro.domain.entity.PostTags;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.socialapppro.domain.entity.Posts;
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
public interface PostTagsMapper extends BaseMapper<PostTags> {
    @Results({
            @Result(column = "name", property = "name", javaType = String.class)
    })
    @Select("SELECT pt.*, p.*, u.username FROM post_tags pt " +
            "JOIN posts p ON pt.post_id = p.post_id " +
            "JOIN users u ON p.user_id = u.user_id " +
            "WHERE pt.tag_id = #{id} " +
            "ORDER BY p.created_at DESC ")
    List<Posts> getPosts(Integer id);
}

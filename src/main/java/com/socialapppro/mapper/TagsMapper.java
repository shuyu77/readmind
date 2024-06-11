package com.socialapppro.mapper;

import com.socialapppro.domain.entity.Tags;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2024-03-27
 */
public interface TagsMapper extends BaseMapper<Tags> {
    @Insert("insert into tags(tag_name,created_at) " +
            "values(#{tagName},#{createdAt})")
    void add(Tags tags);
    @Update("update tags set tag_name=#{tagName} where tag_id=#{tagId}")
    void update(Tags tags);
}
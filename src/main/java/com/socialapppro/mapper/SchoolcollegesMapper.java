package com.socialapppro.mapper;

import com.socialapppro.domain.entity.Colleges;
import com.socialapppro.domain.entity.Schoolcolleges;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface SchoolcollegesMapper extends BaseMapper<Schoolcolleges> {

    @Results({
        @Result(column = "name", property = "name", javaType = String.class)
    })
    @Select("SELECT c.* FROM schoolcolleges sc " +
            "JOIN schools s ON sc.school_id = s.school_id " +
            "JOIN colleges c ON sc.college_id = c.college_id " +
            "WHERE s.name = #{schoolName}")
    List<Colleges> getCollegename(String name);
}

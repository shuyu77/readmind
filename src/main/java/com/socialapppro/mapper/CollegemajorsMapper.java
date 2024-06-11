package com.socialapppro.mapper;

import com.socialapppro.domain.entity.Collegemajors;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.socialapppro.domain.entity.Majors;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author author
 * @since 2024-04-05
 */
public interface CollegemajorsMapper extends BaseMapper<Collegemajors> {

    @Results({
            @Result(column = "name", property = "name", javaType = String.class)
    })
    @Select("SELECT m.* FROM collegemajors cm " +
            "JOIN majors m ON cm.major_id = m.major_id " +
            "JOIN colleges c ON cm.college_id = c.college_id " +
            "WHERE c.name = #{schoolName}")
    List<Majors> getMajors(String college);
}

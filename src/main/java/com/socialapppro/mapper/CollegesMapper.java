package com.socialapppro.mapper;

import com.socialapppro.domain.entity.Colleges;
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
public interface CollegesMapper extends BaseMapper<Colleges> {

    @Insert("insert into colleges(college_id,name) values (#{collegeId},#{name})")
    void add(Colleges colleges);
    @Select("select * from colleges where college_id = #{id}")
    Colleges findById(Integer id);
    @Update("update colleges set name=#{name} where college_id=#{collegeId}")
    void update(Colleges colleges);

    List<Colleges> list(String schoolId);
}

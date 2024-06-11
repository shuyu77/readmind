package com.socialapppro.mapper;

import com.socialapppro.domain.entity.Users;
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
public interface UsersMapper extends BaseMapper<Users> {

    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "school_id", property = "schools",
                    many = @Many(select = "com.socialapppro.mapper.SchoolsMapper.selectById")),
            @Result(column = "college_id", property = "colleges",
                    many = @Many(select = "com.socialapppro.mapper.CollegesMapper.selectById")),
            @Result(column = "major_id", property = "majors",
                    many = @Many(select = "com.socialapppro.mapper.MajorsMapper.selectById"))
    })
    @Select("SELECT * FROM users WHERE user_Id = #{userId}")
    Users getUserWithSchoolAndCollegesAndMajor(Integer userId);
    @Insert("insert into users(password,picture,username,phone_number,introduction,created_at,updated_at,school_id,college_id,major_id,stu_number,account,session_key) " +
            "values(#{password},#{picture},#{username},#{phoneNumber},#{introduction},#{createdAt},#{updatedAt},#{schoolId},#{collegeId},#{majorId},#{stuNumber},#{account},#{sessionKey})")
    void add(Users users);
    void update(Users users);

    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "school_id", property = "schools",
                    many = @Many(select = "com.socialapppro.mapper.SchoolsMapper.selectById")),
            @Result(column = "college_id", property = "colleges",
                    many = @Many(select = "com.socialapppro.mapper.CollegesMapper.selectById")),
            @Result(column = "major_id", property = "majors",
                    many = @Many(select = "com.socialapppro.mapper.MajorsMapper.selectById"))
    })
    @Select("SELECT * FROM users ")
    List<Users> getAll();
}

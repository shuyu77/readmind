package com.socialapppro.mapper;

import com.socialapppro.domain.entity.Majors;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
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
public interface MajorsMapper extends BaseMapper<Majors> {
    @Insert("insert into majors(name) values (#{name})")
    void add(Majors majors);
    @Update("update majors set name=#{name} where major_id=#{majorId}")
    void update(Majors majors);

    List<Majors> list(String collegeId);
}

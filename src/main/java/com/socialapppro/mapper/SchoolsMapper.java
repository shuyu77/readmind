package com.socialapppro.mapper;

import com.socialapppro.domain.entity.Schools;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2024-03-27
 */
public interface SchoolsMapper extends BaseMapper<Schools> {
    @Insert("insert into schools(name,location,description) " +
            "values(#{name},#{location},#{description})")
    void add(Schools schools);

    void update(Schools schools);
}

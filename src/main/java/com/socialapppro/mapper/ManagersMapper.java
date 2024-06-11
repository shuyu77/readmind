package com.socialapppro.mapper;

import com.socialapppro.domain.entity.Managers;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author admin
 * @since 2024-03-27
 */
public interface ManagersMapper extends BaseMapper<Managers> {

//   @Update("update managers set username=#{username},password=#{password},phone_number=#{phoneNumber} where admin_id=#{adminId}")
    void update(Managers managers);


@Update("update managers set password=#{md5String},updated_at=now() where admin_id=#{adminId}")
void updatePwd(String md5String, Integer adminId);
}

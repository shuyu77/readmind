package com.socialapppro.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author admin
 * @since 2024-03-27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
  @EqualsAndHashCode(callSuper = false)
    public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    private String account;

    private String password;

    private String picture;

    private String username;

    private String phoneNumber;

    private String introduction;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Integer schoolId;

    private Integer collegeId;

    private Integer majorId;

    private String stuNumber;

    private String sessionKey;

    @TableField(exist = false)
    private Schools schools;

    @TableField(exist = false)
    private Colleges colleges;

    @TableField(exist = false)
    private Majors majors;


}

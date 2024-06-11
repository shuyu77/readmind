package com.socialapppro.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

/**
 * <p>
 * 
 * </p>
 *
 * @author admin
 * @since 2024-03-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Managers implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "admin_id", type = IdType.AUTO)
    private Integer adminId;

    private String account;

    private String username;

    private String password;

    private String phoneNumber;

    private String role;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
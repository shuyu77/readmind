package com.socialapppro.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
    public class Comments implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "comment_id", type = IdType.AUTO)
      private Integer commentId;

    private Integer userId;

    private Integer postId;

    private String content;

    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

  @TableField(exist = false)
  private String username;

  @TableField(exist = false)
  private String picture;
}

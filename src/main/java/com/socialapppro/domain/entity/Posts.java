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
    public class Posts implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "post_id", type = IdType.AUTO)
      private Integer postId;

    private Integer userId;

    private String title;

    private String content;

    private String images;

    private Integer likesCount;

    private Integer commentsCount;

    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @JsonFormat( pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

    @TableField(exist = false)
    private String username;

    @TableField(exist = false)
    private String picture;
}

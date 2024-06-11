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
    public class Messages implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "message_id", type = IdType.AUTO)
      private Integer messageId;

    private Integer senderId;

    private Integer receiverId;

    private String content;

  @JsonFormat( pattern = "MM-dd HH:mm")
    private LocalDateTime sentAt;

    private Boolean readStatus;

    private Boolean deletedStatus;

    @TableField(exist = false)
    private Integer userId;

    @TableField(exist = false)
    private String username;

    @TableField(exist = false)
    private String picture;
}

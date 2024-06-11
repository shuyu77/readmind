package com.socialapppro.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
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
    public class Majors implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "major_id", type = IdType.AUTO)
      private Integer majorId;

    private String name;
}

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
    public class Schools implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "school_id", type = IdType.AUTO)
      private Integer schoolId;

    private String name;

    private String location;

    private String description;


}

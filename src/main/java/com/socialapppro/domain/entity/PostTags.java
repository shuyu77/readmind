package com.socialapppro.domain.entity;

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
    public class PostTags implements Serializable {

    private static final long serialVersionUID = 1L;

      private Integer postId;

    private Integer tagId;


}

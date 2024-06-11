package com.socialapppro.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author author
 * @since 2024-04-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("pictures")
@ApiModel(value="Pictures对象", description="")
public class Pictures implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "pictures_id", type = IdType.AUTO)
    private Integer picturesId;

    @TableField("posts_id")
    private Integer postsId;

    @TableField("image")
    private String image;

}

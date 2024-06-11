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
 * @since 2024-04-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("collegemajors")
@ApiModel(value="Collegemajors对象", description="")
public class Collegemajors implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "college_id", type = IdType.AUTO)
    private Integer collegeId;

    @TableField("major_id")
    private Integer majorId;


}

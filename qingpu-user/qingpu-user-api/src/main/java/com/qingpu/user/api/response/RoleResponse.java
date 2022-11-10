package com.jason.user.biz.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @author：yangwushuo
 * @time：2022/11/1 22:24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@ApiModel(value = "角色Bo", description = "角色信息描述")
public class RoleBo {

    @ApiModelProperty("英文角色名")
    private String name;

    @ApiModelProperty("中文角色名")
    private String nameZH;

}

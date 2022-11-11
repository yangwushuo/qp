package com.qingpu.user.api.response;

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
@ApiModel(value = "角色响应", description = "角色响应信息")
public class RoleResponse {

    @ApiModelProperty("英文角色名")
    private String name;

    @ApiModelProperty("中文角色名")
    private String nameZH;

}

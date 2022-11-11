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
public class RoleBo {

    private String name;

    private String nameZH;

}

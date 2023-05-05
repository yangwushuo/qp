package com.jason.user.biz.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @author yangwushuo
 * @time 2023/4/25 23:30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UpUserPwdBo {

    private String oldPassword;

    private String newPassword;

}

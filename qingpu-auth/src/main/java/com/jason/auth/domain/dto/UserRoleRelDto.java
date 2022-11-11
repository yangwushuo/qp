package com.jason.auth.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author：yangwushuo
 * @time：2022/10/28 18:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRoleRelDto {

    private Long id;

    private Long userId;

    private Long roleId;

}

package com.jason.auth.domain.dto;

import lombok.*;

/**
 * @author：yangwushuo
 * @time：2022/10/28 18:20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class RoleDto {

    private Long id;

    private String name;

    private String nameZH;

}

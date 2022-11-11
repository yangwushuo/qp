package com.jason.auth.domain.dto;

import com.jason.auth.domain.po.RolePo;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author：yangwushuo
 * @time：2022/10/30 14:14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Accessors(chain = true)
public class ResourceDto {

    private Long id;

    private String routeName;

    private List<RoleDto> roleDtos;

}

package com.jason.auth.domain.dataobject;


import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author：yangwushuo
 * @time：2022/10/28 19:04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Accessors(chain = true)
public class RoleDo {

    private Long id;

    private String name;

    private String nameZH;

}

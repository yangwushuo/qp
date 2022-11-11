package com.jason.auth.domain.po;


import lombok.*;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;

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
public class RolePo {

    private Long id;

    private String name;

    private String nameZH;

}

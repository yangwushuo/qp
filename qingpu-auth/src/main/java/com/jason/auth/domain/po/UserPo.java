package com.jason.auth.domain.dataobject;

import lombok.*;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;

import java.util.List;

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
@Alias("userdo")
public class UserDo {

    private Long id;

    private String username;

    private String password;

    private Integer status;

}

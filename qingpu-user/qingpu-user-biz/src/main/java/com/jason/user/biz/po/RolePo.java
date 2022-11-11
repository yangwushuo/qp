package com.jason.user.biz.po;

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
public class RolePo {

    private Long id;

    private String name;

    private String nameZH;

}

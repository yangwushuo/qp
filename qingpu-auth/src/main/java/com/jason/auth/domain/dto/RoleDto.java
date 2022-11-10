package com.jason.auth.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("role")
public class Role {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "name")
    private String name;

    @TableField(value = "name_zh")
    private String nameZH;

}

// Mapper层，执行查询所有部门数据的操作。
package com.cuiwen.pojo;

// lombok依赖

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// 1. 提高开发效率 2.简化代码
@Data // 主要功能是为了提供类的get、set、equals、hashCode、canEqual、toString方法
@AllArgsConstructor // 主要功能是提供类的全参构造方法
@NoArgsConstructor // 主要功能是提供类的无参构造方法
public class Dept {
    private Integer id; // 部门编号
    private String name; // 部门名称
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 修改时间
}

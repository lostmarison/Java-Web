package com.cuiwen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data // 提供类的 getter、setter 方法
@AllArgsConstructor // 提供类的全参构造方法
@NoArgsConstructor // 提供类的无参构造方法
public class Dept {
    private Integer id; // 部门编号
    private String name; // 部门名称
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 修改时间
}

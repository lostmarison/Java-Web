// Mapper层，执行查询所有部门数据的操作。
package com.cuiwen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Integer code; // 状态码
    private String msg; // 提示信息
    private Object data; // 返回数据

    public static Result success() {
        Result result = new Result();
        result.code = 1;
        result.msg ="success";
        return result;
    }

    public static Result success(Object object) {
        Result result = new Result();
        result.data = object;
        result.code = 1;
        result.msg ="success";
        return result;
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.code = 0;
        result.msg = "error";
        return result;
    }
}

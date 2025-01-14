package com.cuiwen.pojo;

import lombok.Data;

/**
 * 后端统一的响应结果类，用于封装后端接口的返回结果，提供统一的响应格式
 */
@Data // 生成 getter, setter 方法
public class Result {

    private Integer code; // 响应编码：1表示成功，0表示失败
    private String msg; // 响应消息，用于描述操作的结果或错误信息
    private Object data; // 响应数据，用于携带具体的业务数据

    /**
     * 创建一个成功的响应结果，默认编码为1，消息为"success"
     * @return 成功的响应结果对象
     */
    public static Result success() {
        Result result = new Result();
        result.code = 1;
        result.msg = "success";
        return result;
    }

    /**
     * 创建一个携带具体数据的成功响应结果，默认编码为1
     * @param object 要携带的业务数据
     * @return 携带数据的成功响应结果对象
     */
    public static Result success(Object object) {
        Result result = new Result();
        result.data = object;
        result.code = 1;
        result.msg = "success";
        return result;
    }

    /**
     * 创建一个错误的响应结果，默认编码为0
     * @param msg 错误信息
     * @return 错误的响应结果对象
     */
    public static Result error(String msg) {
        Result result = new Result();
        result.msg = msg;
        result.code = 0;
        return result;
    }
}
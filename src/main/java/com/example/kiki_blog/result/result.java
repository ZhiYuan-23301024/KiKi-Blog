package com.example.kiki_blog.result;

import lombok.Data;

import java.io.Serializable;

/**
 * 后端统一返回的结果
 * @param <T>
 */
@Data
public class result<T> implements Serializable {

    private int code;//编码：1为成功，0和其它数字为失败
    private String msg;//错误信息
    private T data;//数据

    public static <T> result<T> success(T data) {
        result<T> result = new result<T>();
        result.setCode(1);
        result.setData(data);
        return result;
    }

    public static <T> result<T> success() {
        result<T> result = new result<T>();
        result.setCode(1);
        return result;
    }

    public static <T> result<T> error(String msg) {
        result<T> result = new result<T>();
        result.setCode(0);
        result.setMsg(msg);
        return result;
    }
}

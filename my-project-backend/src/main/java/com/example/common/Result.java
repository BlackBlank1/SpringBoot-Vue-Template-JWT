package com.example.common;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;

public record Result<T>(int code, T data, String message) {

    public static <T> Result<T> success(T data) {
        return new Result<>(200, data, "请求成功");
    }

    public static <T> Result<T> success() {
        return new Result<>(200, null, "请求成功");
    }

    public static <T> Result<T> failure(int code, String message) {
        return new Result<>(code, null, message);
    }

    public String asJsonString(){
        return JSONObject.toJSONString(this, JSONWriter.Feature.WriteNulls);
    }
}

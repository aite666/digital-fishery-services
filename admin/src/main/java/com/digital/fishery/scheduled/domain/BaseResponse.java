package com.digital.fishery.scheduled.domain;

public class BaseResponse<T> {

    /**
     * 返回状态码
     */
    private int code;

    /**
     * 异常信息
     */
    private String message;

    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

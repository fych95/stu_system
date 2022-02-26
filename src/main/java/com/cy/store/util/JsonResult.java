package com.cy.store.util;

import java.io.Serializable;

public class JsonResult<T> implements Serializable {
    //状态码
    private int state;
    //描述信息
    private String message;
    private T data;//泛型

    public JsonResult() {
    }

    public JsonResult(int state) {
        this.state = state;
    }

    public JsonResult(Throwable e) {
        this.message = e.getMessage();
    }


    public JsonResult(int state, T data) {
        this.state = state;
        this.data = data;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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

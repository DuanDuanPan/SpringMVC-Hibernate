package com.cssrc.util;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/10/10 0010.
 */
public class CommonAjaxResponse<T> implements Serializable {

    public CommonAjaxResponse(String msg, Boolean success, T result) {
        this.msg = msg;
        this.success = success;
        this.result = result;
    }

    private String msg;

    private Boolean success = false;

    private T result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}

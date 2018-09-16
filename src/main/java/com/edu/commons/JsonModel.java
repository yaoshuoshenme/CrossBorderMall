package com.edu.commons;

public class JsonModel {
    private int code;
    private String msg;
    private Object data;

    public JsonModel(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public JsonModel() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static JsonModel ok(){
        return new JsonModel(0, "成功", null);
    }
    public static JsonModel error(){
        return new JsonModel(1, "失败", null);
    }

}

package com.qu.bean;

/**
 * Created by 96283 on 2018/11/8.
 */
public class Result {
    private String code;
    private String message;
    private Object data;

    public Result(String code, String message) {
        this.code = code;
        this.message = message;
    }


    public Result(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result success(Object data){
        return new Result("0","请求成功",data);
    }
    public static Result success(){
        return new Result("0","请求成功");
    }
    public static Result fail(){
        return new Result("1","请求失败");
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

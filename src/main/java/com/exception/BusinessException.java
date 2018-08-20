package com.exception;

/**
 * 定义业务异常
 */
public class BusinessException extends Exception{
    private int code;
    private String message;

    public BusinessException(){
        this.code = 200;
        this.message = "操作成功";
    }

    public BusinessException(int code, String message){
        this.code = code;
        this.message = message;
    }

    public BusinessException(String message){
        super();
        this.message = message;
    }

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

}

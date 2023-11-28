package edu.whu.demo.exception;

import lombok.Data;

@Data
public class TodoException extends Exception{
    //定义各种错误代码常量
    public final static int INPUT_ERROR = 100;
    public final static int UPDATE_ERROR = 101;
    public final static int DELETE_ERROR = 102;
    public final static int GET_ERROR = 103;
    int code; //自定义的错误代码
    public TodoException(int code,String message){
        super(message);
        this.code=code;
    }
}

package com.example.demo.po.config;

public enum Api {
    //普通操作相关
    SERVRE_ERROR(99, "服务器内部错误"),
    SUCCESS(100, "操作成功"),
    //用户相关
    USER_NOT_EXIST(201, "用户名错误"),
    USER_PASS_ERR(202, "密码错误"),
    USER_NAME_EXIST(203, "该用户名已经存在"),
    USER_PHONE_EXIST(204, "该手机号已经被注册"),
    USER_OLD_PASS_ERR(205, "原密码错误"),
    USER_MSG_LATEST(206, "消息数据已经最新"),
    NO_USERS(207, "没有用户"),
    PARMETER_NOT_EXIT(208, "参数不存在"),
    NO_PERMISSION(209, "没有权限");

    private int code;
    private String msg;

    Api(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int code() {
        return this.code;
    }

    public String msg() {
        return this.msg;
    }
}

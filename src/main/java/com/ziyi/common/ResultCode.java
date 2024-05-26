package com.ziyi.common;

import lombok.Getter;

/**
 * 自定义返回码
 *
 */
@Getter
public enum ResultCode {

    SUCCESS(200, "请求成功");


    /**
     * 状态码
     */
    private final int code;

    /**
     * 信息
     */
    private final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}

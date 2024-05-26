package com.ziyi.model;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ziyi.common.ResultCode;

public record ResultData<T>(int code, T data, String message) {

   private final static Gson GSON = new GsonBuilder().serializeNulls().create();

    public static <T> ResultData<T> success() {
        return success(null);
    }

    public static <T> ResultData<T> success(T data) {
        return new ResultData<>(ResultCode.SUCCESS.getCode(), data, ResultCode.SUCCESS.getMessage());
    }



    public String asJsonString() {
        return GSON.toJson(this);
    }


}

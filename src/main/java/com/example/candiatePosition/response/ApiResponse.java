package com.example.candiatePosition.response;

import lombok.*;

@Getter
@Setter
public class ApiResponse<T> {

    private String message;

    private boolean success;

    private T data;

    public ApiResponse() {

    }

    public ApiResponse(String message, boolean success, T data) {
        this.message = message;
        this.success = success;
        this.data = data;
    }


//    public static <T> ApiResponse<T> success(String message, T data) {
//        return ApiResponse.<T>builder()
//                .success(true)
//                .message(message)
//                .data(data)
//                .build();
//    }
//
//    public static <T> ApiResponse<T> failure(String message, T data) {
//        return ApiResponse.<T>builder()
//                .success(false)
//                .message(message)
//                .data(data)
//                .build();
//    }
//
//    public static <T> ApiResponse<T> failure(String message) {
//        return ApiResponse.<T>builder()
//                .success(false)
//                .message(message)
//                .data(null)
//                .build();
//    }


    public static <T> ApiResponse<T> response(String message, boolean success, T data) {
        return new ApiResponse<>(message, success, data);
    }
}

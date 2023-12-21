package com.dslikelion.demo.domain;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BaseApiResponse<T> {
    private Integer status;
    private Boolean success;
    private String message;
    private T data;

    public BaseApiResponse(String message, T data){
        this.status = HttpStatus.OK.value();
        this.success = true;
        this.message = message;
        this.data = data;
    }

}

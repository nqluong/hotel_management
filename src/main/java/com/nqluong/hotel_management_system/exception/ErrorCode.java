package com.nqluong.hotel_management_system.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {

    UNCATEGORIZED_EXCEPTION("Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),
    ROOM_EXISTED("Room existed", HttpStatus.BAD_REQUEST)
    ;
    private String message;
    private HttpStatusCode httpStatusCode;

    ErrorCode(String message, HttpStatusCode httpStatusCode){
        this.message = message;
        this.httpStatusCode = httpStatusCode;
    }
}

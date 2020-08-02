package com.sushant.rest.webservices.restfulwebservices.exception;

import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@ResponseBody
public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String details;

    public ExceptionResponse (Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp ( ) {
        return timestamp;
    }

    public String getMessage ( ) {
        return message;
    }

    public String getDetails ( ) {
        return details;
    }
}

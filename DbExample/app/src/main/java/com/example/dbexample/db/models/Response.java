package com.example.dbexample.db.models;

import com.example.dbexample.enums.ResponseCode;

public class Response {
    private ResponseCode responseCode;
    private String responseMessage;

    public Response(ResponseCode responseCode , String responseMessage){
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }


}

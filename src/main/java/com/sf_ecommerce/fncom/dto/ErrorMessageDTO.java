package com.sf_ecommerce.fncom.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class ErrorMessageDTO implements Serializable {

    @JsonProperty("type")
    private String messageType;

    @JsonProperty
    private String message;

    public ErrorMessageDTO() {
    }

    public ErrorMessageDTO(String messageType, String message) {
        this.messageType = messageType;
        this.message = message;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

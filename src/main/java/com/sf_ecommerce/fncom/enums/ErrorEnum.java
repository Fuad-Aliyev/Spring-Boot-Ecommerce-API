package com.sf_ecommerce.fncom.enums;

public enum ErrorEnum {

    INVALID_INPUT(400),

    INVALID_JSON_FORMAT(400),

    JDBC(500),

    OBJECT_CREATION_ERROR(500),

    GENERAL_ERROR(500),

    ENTITY_NOT_FOUND(404);

    private int errorCode;

    private ErrorEnum(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}

package com.sf_ecommerce.fncom.exceptions;

import com.sf_ecommerce.fncom.constant.OtherConstant;
import com.sf_ecommerce.fncom.dto.response.errors.ErrorMessageDTO;
import com.sf_ecommerce.fncom.enums.ErrorEnum;

public class RestException extends RuntimeException {

    private static final long serialVersionUID = 6498067149468851151L;

    private int status;
    private String messageType;
    private String message;
    private String parameterName;

    public RestException(int status, String messageType, String message) {
        super(message);
        this.status = status;
        this.messageType = messageType;
        this.message = message;
    }

    public RestException(ErrorEnum errorEnum) {
        super(errorEnum.name());
        this.message = errorEnum.name();
        this.status = errorEnum.getErrorCode();
        this.messageType = OtherConstant.ERROR_TYPE;
    }

    public RestException(ErrorEnum errorEnum, String parameterName) {
        super(errorEnum.name());
        this.message = errorEnum.name();
        this.status = errorEnum.getErrorCode();
        this.parameterName = parameterName;
        this.messageType = OtherConstant.ERROR_TYPE;
    }

    public ErrorMessageDTO getErrorMessageDTO() {
        ErrorMessageDTO errorMessageDTO = new ErrorMessageDTO(message, messageType);
        return errorMessageDTO;
    }


    public String getParameterName() {
        return parameterName;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

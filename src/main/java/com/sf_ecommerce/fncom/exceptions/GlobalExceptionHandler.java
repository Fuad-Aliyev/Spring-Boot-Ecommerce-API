package com.sf_ecommerce.fncom.exceptions;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sf_ecommerce.fncom.constant.OtherConstant;
import com.sf_ecommerce.fncom.dto.response.errors.BaseResponseDTO;
import com.sf_ecommerce.fncom.enums.ErrorEnum;
import com.sf_ecommerce.fncom.processIO.generator.ResponseGenerator;
import org.hibernate.exception.GenericJDBCException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.web.header.Header;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.stream.Collectors;


@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final ResponseGenerator<Object> responseGenerator = new ResponseGenerator<>();

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public final BaseResponseDTO handelAllExceptions(Exception ex) {
        logger.error(ex.getMessage(), ex);
        return responseGenerator.generateErrorResponse(OtherConstant.ERROR_TYPE, ex.getMessage(),
                ErrorEnum.GENERAL_ERROR.getErrorCode());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    protected BaseResponseDTO handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(x -> x.getDefaultMessage()).collect(Collectors.toList());
        return responseGenerator.generateErrorResponse(OtherConstant.ERROR_TYPE,
                errors,
                ErrorEnum.INVALID_INPUT.getErrorCode());
    }

    @ExceptionHandler(InvalidInputException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public final BaseResponseDTO<Object> invalidInputException(Exception ex, WebRequest webRequest) {
        logger.error(ex.getMessage(), ex);
        return responseGenerator.generateErrorResponse(OtherConstant.ERROR_TYPE, ex.getMessage(),
                ErrorEnum.INVALID_INPUT.getErrorCode());
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public final BaseResponseDTO<Object> nullPointerException(Exception ex, WebRequest webRequest) {
        logger.error(ex.getMessage(), ex);
        return responseGenerator.generateErrorResponse(OtherConstant.ERROR_TYPE, ex.getMessage(),
                ErrorEnum.INVALID_INPUT.getErrorCode());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public final BaseResponseDTO<Object> invalidJsonException(Exception ex) {
        logger.error(ex.getMessage(), ex);
        return responseGenerator.generateErrorResponse(OtherConstant.ERROR_TYPE, ex.getMessage(),
                ErrorEnum.INVALID_JSON_FORMAT.getErrorCode());
    }

    @ExceptionHandler(GenericJDBCException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public final BaseResponseDTO<Object> getGenericsJDBCException(Exception ex) {
        logger.error(ex.getMessage(), ex);
        return responseGenerator.generateErrorResponse(OtherConstant.ERROR_TYPE, ex.getMessage(),
                ErrorEnum.JDBC.getErrorCode());
    }
}

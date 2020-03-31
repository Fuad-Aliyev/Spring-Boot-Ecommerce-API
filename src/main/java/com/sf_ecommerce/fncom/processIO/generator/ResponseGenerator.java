package com.sf_ecommerce.fncom.processIO.generator;

import com.sf_ecommerce.fncom.dto.BaseResponseDTO;
import com.sf_ecommerce.fncom.dto.ErrorMessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class ResponseGenerator<T> {

    private static Logger logger = LoggerFactory.getLogger(ResponseGenerator.class);

    public BaseResponseDTO<T> generateErrorResponse(String errorType,
                                                    String errorMessage,
                                                    int status) {
        BaseResponseDTO<T> baseResponseDTO = new BaseResponseDTO<>();
        List<ErrorMessageDTO> errorMessageDTOS = new ArrayList<>();
        logger.error(errorMessage, errorType);

        errorMessageDTOS.add(new ErrorMessageDTO(errorType, errorMessage));
        baseResponseDTO.setStatus(status);
        baseResponseDTO.setErrorMessageDTO(errorMessageDTOS);
        baseResponseDTO.setTimeStamp(LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond());
        logger.error("Error Response: " + baseResponseDTO.toString());
        return baseResponseDTO;
    }

    public BaseResponseDTO<T> generateErrorResponse(String errorType,
                                                    List<String> errorMessageList,
                                                    int status) {
        BaseResponseDTO<T> baseResponseDTO = new BaseResponseDTO<>();
        List<ErrorMessageDTO> errorMessageDTOS = errorMessageList.stream()
                .map(errorMessage -> {
                    logger.error(errorMessage, errorType);
                    ErrorMessageDTO errorMessageDTO = new ErrorMessageDTO();
                    errorMessageDTO.setMessageType(errorType);
                    errorMessageDTO.setMessage(errorMessage);
                    return errorMessageDTO;
                }).collect(Collectors.toList());

        baseResponseDTO.setStatus(status);
        baseResponseDTO.setErrorMessageDTO(errorMessageDTOS);
        baseResponseDTO.setTimeStamp(LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond());
        logger.error("Error Response: " + baseResponseDTO.toString());
        return baseResponseDTO;
    }
}

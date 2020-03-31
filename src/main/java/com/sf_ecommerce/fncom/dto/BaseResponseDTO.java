package com.sf_ecommerce.fncom.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponseDTO<T> implements Serializable {

    private Long timeStamp;
    @JsonProperty("errorMessages")
    private List<ErrorMessageDTO> errorMessageDTO;
    private int status;
    private List<T> data;

    public BaseResponseDTO() {
    }

    public BaseResponseDTO(T data) {
        List<T> localData = new ArrayList<>();
        localData.add(data);
        this.data = localData;
    }

    public BaseResponseDTO(List<T> data) {
        this.data = data;
    }

    public BaseResponseDTO(Long timeStamp, int status) {
        this.timeStamp = timeStamp;
        this.status = status;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        if (Objects.isNull(data))
            this.data = new ArrayList<>();
        this.data = data;
    }

    public void setData(T data) {
        List<T> localData = new ArrayList<>();
        localData.add(data);
        this.data = localData;
    }

    public int getStatus() {
        if (status == 0)
            return 200;
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<ErrorMessageDTO> getErrorMessageDTO() {
        return errorMessageDTO;
    }

    public void setErrorMessageDTO(List<ErrorMessageDTO> errorMessageDTO) {
        if (Objects.isNull(errorMessageDTO))
            this.errorMessageDTO = new ArrayList<>();
        this.errorMessageDTO = errorMessageDTO;
    }

    public void setErrorMessagetDTO(ErrorMessageDTO errorMessagetDTO) {
        if (Objects.isNull(errorMessagetDTO))
            this.errorMessageDTO = new ArrayList<>();
        List<ErrorMessageDTO> errorMessageDTOS = new ArrayList<>();
        errorMessageDTOS.add(errorMessagetDTO);
        this.errorMessageDTO = errorMessageDTOS;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "BaseResponseDTO{" +
                "timeStamp='" + timeStamp + '\'' +
                ", errorMessageDTO=" + errorMessageDTO +
                ", status=" + status +
                ", data=" + data +
                '}';
    }
}

package com.sf_ecommerce.fncom.dto.request.create.products;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.executable.ValidateOnExecution;
import java.io.Serializable;

@Validated
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PriceDetailDTO implements Serializable {

    private static final long serialVersionUID = -7511226391407993906L;

    @NotBlank(message = "CurrencyCode can not be empty in price details")
    private String currencyCode;

    @NotBlank(message = "amount can not be empty in price details")
    private String amount;

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PriceDetailDTO{" +
                "currencyCode='" + currencyCode + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}

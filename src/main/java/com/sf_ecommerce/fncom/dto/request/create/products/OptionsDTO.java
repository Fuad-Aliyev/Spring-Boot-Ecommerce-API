package com.sf_ecommerce.fncom.dto.request.create.products;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Validated
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OptionsDTO implements Serializable {

    private static final long serialVersionUID = -6471939037270101840L;

    @NotBlank(message = "name parameter in option can not be empty")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OptionsDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}

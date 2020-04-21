package com.sf_ecommerce.fncom.dto.request.create.products;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sf_ecommerce.fncom.entities.products.CustomCollectionEntity;
import com.sf_ecommerce.fncom.entities.products.ProductEntity;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Validated
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CollectDTO implements Serializable {

    private static final long serialVersionUID = -2481852564256293154L;

    @NotNull(message = "position can not be empty in collect data")
    private Integer position;

    @NotBlank(message = "sortValue can not be empty in collect data")
    private String sortValue;

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getSortValue() {
        return sortValue;
    }

    public void setSortValue(String sortValue) {
        this.sortValue = sortValue;
    }

    @Override
    public String toString() {
        return "CollectDTO{" +
                "position=" + position +
                ", sortValue='" + sortValue + '\'' +
                '}';
    }
}

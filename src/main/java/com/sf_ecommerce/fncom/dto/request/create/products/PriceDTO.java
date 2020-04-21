package com.sf_ecommerce.fncom.dto.request.create.products;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sf_ecommerce.fncom.entities.products.PriceDetailEntity;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.validation.annotation.Validated;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import java.io.Serializable;

@Validated
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PriceDTO implements Serializable {

    private static final long serialVersionUID = -1520950901750295133L;

    @Valid
    private PriceDetailDTO price;

    @Valid
    private PriceDetailDTO compareAtPrice;

    public PriceDetailDTO getPrice() {
        return price;
    }

    public void setPrice(PriceDetailDTO price) {
        this.price = price;
    }

    public PriceDetailDTO getCompareAtPrice() {
        return compareAtPrice;
    }

    public void setCompareAtPrice(PriceDetailDTO compareAtPrice) {
        this.compareAtPrice = compareAtPrice;
    }

    @Override
    public String toString() {
        return "PriceDTO{" +
                "price=" + price +
                ", compareAtPrice=" + compareAtPrice +
                '}';
    }
}

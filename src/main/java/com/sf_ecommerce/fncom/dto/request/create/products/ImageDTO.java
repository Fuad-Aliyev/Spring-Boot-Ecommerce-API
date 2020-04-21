package com.sf_ecommerce.fncom.dto.request.create.products;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sf_ecommerce.fncom.entities.products.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Validated
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImageDTO implements Serializable {

    private static final long serialVersionUID = 8035286978341732548L;

    @NotNull(message = "position in image can not be empty")
    private Integer position;

    @NotBlank(message = "src in image can not be empty")
    private String src;

    @NotNull(message = "width in image can not be empty")
    private Integer width;

    @NotNull(message = "height in image can not be empty")
    private Integer height;

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "ImageDTO{" +
                "position=" + position +
                ", src='" + src + '\'' +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}

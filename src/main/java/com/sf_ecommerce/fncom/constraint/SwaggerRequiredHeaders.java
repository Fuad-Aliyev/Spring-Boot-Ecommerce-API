package com.sf_ecommerce.fncom.constraint;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ApiImplicitParams(
        {
                @ApiImplicitParam(
//                        name = Constants.HEADER_KEY_LANGUAGE,
                        paramType = "header",
                        dataTypeClass = String.class
                ),
        }
)
public @interface SwaggerRequiredHeaders {

}


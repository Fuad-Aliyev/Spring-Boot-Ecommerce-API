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
                @ApiImplicitParam(
//                        name = Constants.REQUEST_PARAMETER_KEY_PAGE_INDEX,
                        paramType = "query",
                        dataTypeClass = Integer.class,
                        defaultValue = "1"
                ),
                @ApiImplicitParam(
//                        name = Constants.REQUEST_PARAMETER_KEY_PAGE_SIZE,
                        paramType = "query",
                        dataTypeClass = Integer.class,
                        defaultValue = "10"
                ),
        }
)
public @interface SwaggerPaginationParameters {

}


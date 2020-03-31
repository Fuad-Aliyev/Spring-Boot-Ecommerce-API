package com.sf_ecommerce.fncom.constraint;

import com.sf_ecommerce.fncom.constant.ErrorConstantMessage;
import com.sf_ecommerce.fncom.constant.OtherConstant;
import com.sf_ecommerce.fncom.constant.RegexConstant;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD, PARAMETER, LOCAL_VARIABLE})
@Retention(RUNTIME)
@Constraint(validatedBy = {})
@Documented
@Pattern(regexp = RegexConstant.INTEGER_REGEX, message = ErrorConstantMessage.INVALID_PARAMETER)
public @interface OnlyInteger {

    String message() default OtherConstant.EMPTY;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}

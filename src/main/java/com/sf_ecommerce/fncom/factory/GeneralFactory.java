package com.sf_ecommerce.fncom.factory;

import com.sf_ecommerce.fncom.enums.ErrorEnum;
import com.sf_ecommerce.fncom.exceptions.RestException;

public final class GeneralFactory {

    public final static <T> T createObject(Class<T> clazz) {
        T t = null;
        try {
            t = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RestException(ErrorEnum.OBJECT_CREATION_ERROR);
        }
        return t;
    }
}

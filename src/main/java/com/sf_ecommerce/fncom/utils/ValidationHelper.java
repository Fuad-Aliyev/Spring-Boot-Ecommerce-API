package com.sf_ecommerce.fncom.utils;

import java.math.BigDecimal;
import java.util.Collection;

public interface ValidationHelper {

    default boolean checkIsNullOrEmpty(String data) {
        return data == null || data.isEmpty();
    }

    default boolean checkIsNullOrZero(BigDecimal decimal) {
        return decimal == null || decimal.compareTo(BigDecimal.ZERO) == 0;
    }

    default boolean checkIsNullOrLessEqualToZero(BigDecimal decimal) {
        return decimal == null || decimal.compareTo(BigDecimal.ZERO) <= 0;
    }

    default boolean checkIsNullOrLessThanOne(BigDecimal decimal) {
        return decimal == null || decimal.compareTo(BigDecimal.ONE) < 1;
    }

    default boolean checkIsNullOrHaveElements(Collection collection) {
        return collection == null || collection.size() == 0;
    }
}
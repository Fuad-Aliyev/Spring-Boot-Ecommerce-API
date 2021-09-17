package com.sf_ecommerce.fncom.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoundingUtils {
    public static final int DB_FRACTIONAL_PART = 5;
    public static final int END_USER_FRACTIONAL_PART = 2;

    public static BigDecimal round(BigDecimal amount) {
        return round(amount, END_USER_FRACTIONAL_PART);
    }

    public static BigDecimal round(BigDecimal amount, int newScale) {
        return amount.setScale(newScale, RoundingMode.HALF_EVEN);
    }

}

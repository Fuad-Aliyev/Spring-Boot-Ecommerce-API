package com.sf_ecommerce.fncom.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public final class CommonUtils {

    public static final Date convertLocalDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}

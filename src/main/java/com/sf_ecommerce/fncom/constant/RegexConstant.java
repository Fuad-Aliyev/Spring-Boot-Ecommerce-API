package com.sf_ecommerce.fncom.constant;

public final class RegexConstant {

    public static final String INTEGER_REGEX="^[0-9]*$";

    public static final String DOUBLE_REGEX="";

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_PATTERN = "yyyy-MM-dd";

    public static final String DATE_DOT_PATTERN = "dd.MM.yyyy";

    public static final String PIN_CODE_REGEX ="^.{7}$" ;

    public static final String SERIAL_NUMBER_REGEX ="^.{20}$" ;

    public static final String PHONE = "^994(55|50|51|77)\\d{7}";

    public static final String EMAIL = "^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
}

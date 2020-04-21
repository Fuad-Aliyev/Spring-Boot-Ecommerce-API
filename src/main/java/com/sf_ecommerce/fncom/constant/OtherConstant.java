package com.sf_ecommerce.fncom.constant;

public final class OtherConstant {

    public static final String SPACE = " ";

    public static final String ERROR_TYPE = "error";

    public static final String ZERO_PREFIX = "0";

    public static final String DOT = ".";

    public static final String EMPTY = "";

    public static final String NEW_LOAN_COMPANE = "Yeni kredit kampaniyası";

    public static final String XREF_HEADER_NAME = "X-Request-ID";

    public static final String IS_TRADE_TYPE = "S";

    public interface RESPONSE_STATUS {

        int INTERNAL_SERVER_ERROR = 500;
        int NOT_FOUND = 404;
        int CREATED = 201;
        int SUCCESS = 200;
        int FORBIDDEN = 403;
        int BAD_REQUEST = 400;
    }
}

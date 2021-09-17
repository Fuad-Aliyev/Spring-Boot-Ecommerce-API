package com.sf_ecommerce.fncom.container;

import java.math.BigInteger;

public interface TraceHelper {
    default long toLong(String hex) {
        if (hex == null || hex.isEmpty()) {
            return 1L;
        }
        long traceId = new BigInteger(hex, 16).longValue();
        if (traceId == 0) {
            return 1L;
        }
        return traceId;
    }
}


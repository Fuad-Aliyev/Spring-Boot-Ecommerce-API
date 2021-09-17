package com.sf_ecommerce.fncom.container;

import com.sf_ecommerce.fncom.utils.BaseLogMessage;
import com.sf_ecommerce.fncom.utils.LoggingService;

public interface AdvancedLoggingService extends LoggingService {
    default void transaction(String message) {
        this.infoLog(message);
    }

    default void transaction(String message, Object... objects) {
        this.infoLog(message, objects);
    }

    default void transaction(BaseLogMessage message) {
        this.infoLog(message);
    }
}

package com.sf_ecommerce.fncom.utils;

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


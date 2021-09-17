package com.sf_ecommerce.fncom.container;

import com.sf_ecommerce.fncom.utils.Log4j2ServiceImpl;
import com.sf_ecommerce.fncom.utils.LoggingProvider;

public final class LoggingFactory {
    private LoggingFactory() {
    }

    public static AdvancedLoggingService of(String className) {
        return convertToAdvancedLoggingService((LoggingProvider)null, className);
    }

    public static AdvancedLoggingService of(Class clazz) {
        return convertToAdvancedLoggingService((LoggingProvider)null, clazz.getName());
    }

    public static AdvancedLoggingService of(String className, LoggingProvider loggingProvider) {
        return convertToAdvancedLoggingService(loggingProvider, className);
    }

    public static AdvancedLoggingService of(Class clazz, LoggingProvider loggingProvider) {
        return convertToAdvancedLoggingService(loggingProvider, clazz.getName());
    }

    private static AdvancedLoggingService convertToAdvancedLoggingService(LoggingProvider loggingProvider, String className) {
        if (loggingProvider == null) {
            return (AdvancedLoggingService) new Log4j2ServiceImpl(className);
        } else {
            switch(loggingProvider) {
                case LOG4J2:
                    return (AdvancedLoggingService) new Log4j2ServiceImpl(className);
                case LOG4J:
                case LOGBACK:
                    throw new UnsupportedOperationException("Logging provider not implemented");
                default:
                    return (AdvancedLoggingService) new Log4j2ServiceImpl(className);
            }
        }
    }
}


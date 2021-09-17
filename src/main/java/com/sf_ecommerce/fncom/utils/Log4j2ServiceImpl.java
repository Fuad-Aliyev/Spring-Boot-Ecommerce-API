package com.sf_ecommerce.fncom.utils;

import org.apache.logging.log4j.*;

public class Log4j2ServiceImpl implements AdvancedLoggingService {
    private Logger logger;
    private static final Marker LOG_MESSAGE_MARKER = MarkerManager.getMarker("IDENTIFIED_LOG_MESSAGE");
    private static final Marker BUSINESS_MESSAGE_MARKER = MarkerManager.getMarker("BUSINESS_MESSAGE");
    private static final Level BUSINESS_LEVEL = Level.forName("BUSINESS", 700);

    public Log4j2ServiceImpl() {
        this.logger = LogManager.getLogger(this.getClass());
    }

    public Log4j2ServiceImpl(String className) {
        this.logger = LogManager.getLogger(className);
    }

    public Log4j2ServiceImpl(Class clazz) {
        this.logger = LogManager.getLogger(clazz);
    }

    public void traceLog(String message) {
        this.logger.trace(message);
    }

    public void traceLog(BaseLogMessage message) {
        this.logger.trace(LOG_MESSAGE_MARKER, message);
    }

    public void traceLog(String message, Object... objects) {
        this.logger.trace(message, objects);
    }

    public void traceLog(String message, Throwable throwable) {
        this.logger.trace(message, throwable);
    }

    public void traceLog(BaseLogMessage message, Throwable throwable) {
        this.logger.trace(LOG_MESSAGE_MARKER, message, throwable);
    }

    public void debugLog(String message) {
        this.logger.debug(message);
    }

    public void debugLog(BaseLogMessage message) {
        this.logger.debug(LOG_MESSAGE_MARKER, message);
    }

    public void debugLog(String message, Object... objects) {
        this.logger.debug(message, objects);
    }

    public void debugLog(String message, Throwable throwable) {
        this.logger.debug(message, throwable);
    }

    public void debugLog(BaseLogMessage message, Throwable throwable) {
        this.logger.debug(LOG_MESSAGE_MARKER, message, throwable);
    }

    public void infoLog(String message) {
        this.logger.info(message);
    }

    public void infoLog(BaseLogMessage message) {
        this.logger.info(LOG_MESSAGE_MARKER, message);
    }

    public void infoLog(String message, Object... objects) {
        this.logger.info(message, objects);
    }

    public void infoLog(String message, Throwable throwable) {
        this.logger.info(message, throwable);
    }

    public void infoLog(BaseLogMessage message, Throwable throwable) {
        this.logger.info(LOG_MESSAGE_MARKER, message, throwable);
    }

    public void warnLog(String message) {
        this.logger.warn(message);
    }

    public void warnLog(BaseLogMessage message) {
        this.logger.warn(LOG_MESSAGE_MARKER, message);
    }

    public void warnLog(String message, Object... objects) {
        this.logger.warn(message, objects);
    }

    public void warnLog(String message, Throwable throwable) {
        this.logger.warn(message, throwable);
    }

    public void warnLog(BaseLogMessage message, Throwable throwable) {
        this.logger.warn(LOG_MESSAGE_MARKER, message, throwable);
    }

    public void errorLog(String message) {
        this.logger.error(message);
    }

    public void errorLog(BaseLogMessage message) {
        this.logger.error(LOG_MESSAGE_MARKER, message);
    }

    public void errorLog(String message, Object... objects) {
        this.logger.error(message, objects);
    }

    public void errorLog(String message, Throwable throwable) {
        this.logger.error(message, throwable);
    }

    public void errorLog(BaseLogMessage message, Throwable throwable) {
        this.logger.error(LOG_MESSAGE_MARKER, message, throwable);
    }

    public void fatalLog(String message) {
        this.logger.fatal(message);
    }

    public void fatalLog(BaseLogMessage message) {
        this.logger.fatal(LOG_MESSAGE_MARKER, message);
    }

    public void fatalLog(String message, Object... objects) {
        this.logger.fatal(message, objects);
    }

    public void fatalLog(String message, Throwable throwable) {
        this.logger.fatal(message, throwable);
    }

    public void fatalLog(BaseLogMessage message, Throwable throwable) {
        this.logger.fatal(LOG_MESSAGE_MARKER, message, throwable);
    }

    public void businessLog(String message) {
        this.logger.log(BUSINESS_LEVEL, message);
    }

    public void businessLog(BaseLogMessage message) {
        this.logger.log(BUSINESS_LEVEL, BUSINESS_MESSAGE_MARKER, message);
    }

    public void businessLog(String message, Object... objects) {
        this.logger.log(BUSINESS_LEVEL, message, objects);
    }

    public void businessLog(String message, Throwable throwable) {
        this.logger.log(BUSINESS_LEVEL, message, throwable);
    }

    public void businessLog(BaseLogMessage message, Throwable throwable) {
        this.logger.log(BUSINESS_LEVEL, BUSINESS_MESSAGE_MARKER, message, throwable);
    }

    public void log(Level level, String message) {
        this.logger.log(level, message);
    }

    public void log(Level level, String message, Object... objects) {
        this.logger.log(level, message, objects);
    }

    public void log(Level level, BaseLogMessage message) {
        this.logger.log(level, LOG_MESSAGE_MARKER, message);
    }

    public void log(Level level, String message, Throwable throwable) {
        this.logger.log(level, message, throwable);
    }

    public void log(Level level, BaseLogMessage message, Throwable throwable) {
        this.logger.log(level, LOG_MESSAGE_MARKER, message, throwable);
    }
}

package com.sf_ecommerce.fncom.utils;

import org.apache.logging.log4j.Level;

public interface LoggingService {
    void traceLog(String var1);

    void traceLog(BaseLogMessage var1);

    void traceLog(String var1, Object... var2);

    void traceLog(String var1, Throwable var2);

    void traceLog(BaseLogMessage var1, Throwable var2);

    void debugLog(String var1);

    void debugLog(BaseLogMessage var1);

    void debugLog(String var1, Object... var2);

    void debugLog(String var1, Throwable var2);

    void debugLog(BaseLogMessage var1, Throwable var2);

    void infoLog(String var1);

    void infoLog(BaseLogMessage var1);

    void infoLog(String var1, Object... var2);

    void infoLog(String var1, Throwable var2);

    void infoLog(BaseLogMessage var1, Throwable var2);

    void warnLog(String var1);

    void warnLog(BaseLogMessage var1);

    void warnLog(String var1, Object... var2);

    void warnLog(String var1, Throwable var2);

    void warnLog(BaseLogMessage var1, Throwable var2);

    void errorLog(String var1);

    void errorLog(BaseLogMessage var1);

    void errorLog(String var1, Object... var2);

    void errorLog(String var1, Throwable var2);

    void errorLog(BaseLogMessage var1, Throwable var2);

    void fatalLog(String var1);

    void fatalLog(BaseLogMessage var1);

    void fatalLog(String var1, Object... var2);

    void fatalLog(String var1, Throwable var2);

    void fatalLog(BaseLogMessage var1, Throwable var2);

    void businessLog(String var1);

    void businessLog(BaseLogMessage var1);

    void businessLog(String var1, Object... var2);

    void businessLog(String var1, Throwable var2);

    void businessLog(BaseLogMessage var1, Throwable var2);

    void log(Level var1, String var2);

    void log(Level var1, String var2, Object... var3);

    void log(Level var1, BaseLogMessage var2);

    void log(Level var1, String var2, Throwable var3);

    void log(Level var1, BaseLogMessage var2, Throwable var3);
}


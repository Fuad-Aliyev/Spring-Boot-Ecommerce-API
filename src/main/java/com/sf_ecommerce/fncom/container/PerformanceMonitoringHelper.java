package com.sf_ecommerce.fncom.container;

import com.sf_ecommerce.fncom.utils.LoggingService;
import org.springframework.util.StopWatch;

public interface PerformanceMonitoringHelper {
    LoggingService LOG = LoggingFactory.of(PerformanceMonitoringHelper.class);
    String group();

    default StopWatch start(String taskName) {
        StopWatch stopWatch = new StopWatch(group());
        stopWatch.start(taskName);
        return stopWatch;
    }

    default void stop(StopWatch stopWatch) {
        stopWatch.stop();
        LOG.debugLog(
                "{}[{}] executed {} milli seconds.",
                stopWatch.getId(),
                stopWatch.getLastTaskName(),
                stopWatch.getLastTaskTimeMillis()
        );
    }
}


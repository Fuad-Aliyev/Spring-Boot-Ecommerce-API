package com.sf_ecommerce.fncom.container;

import com.sf_ecommerce.fncom.utils.Constants;

public interface KafkaConsumer extends TraceHelper, BaseConsumer, PerformanceMonitoringHelper {

    @Override
    default String group() {
        return Constants.GROUP_KAFKA_CONSUMER;
    }
}

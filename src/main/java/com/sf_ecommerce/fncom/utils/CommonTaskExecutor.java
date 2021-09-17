package com.sf_ecommerce.fncom.utils;

import brave.Span;
import brave.Tracer;
import brave.propagation.TraceContextOrSamplingFlags;
import brave.propagation.TraceIdContext;
import com.sf_ecommerce.fncom.container.PerformanceMonitoringHelper;
import com.sf_ecommerce.fncom.container.TraceHelper;
import com.sf_ecommerce.fncom.enums.ConsumerTypesEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@RequiredArgsConstructor
@Slf4j
public class CommonTaskExecutor implements TraceHelper, PerformanceMonitoringHelper {
    private final Tracer tracer;

    public void handle(ConsumerTypesEnum consumerTypesEnum, String tracerId, Runnable listener) {
        StopWatch stopWatch = start(consumerTypesEnum.getName());
        Span span = tracer.nextSpan(
                TraceContextOrSamplingFlags.create(
                        TraceIdContext.newBuilder()
                                .traceId(toLong(tracerId))
                                .build()
                )
        );
        try (Tracer.SpanInScope scopedSpan = tracer.withSpanInScope(span)) {
            listener.run();
        } finally {
            stop(stopWatch);
            span.finish();
        }
    }

    @Override
    public String group() {
        return Constants.GROUP_THREAD_EXECUTOR;
    }
}


package com.sf_ecommerce.fncom.services.grpc;

import brave.Span;
import brave.Tracer;
import brave.propagation.TraceContextOrSamplingFlags;
import brave.propagation.TraceIdContext;
import com.sf_ecommerce.fncom.constraint.GrpcService;
import com.sf_ecommerce.fncom.utils.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.Optional;

@Profile(Constants.GRPC_PROFILE)
@GrpcService
@RequiredArgsConstructor
@Service
@Slf4j
//public class BackOfficeIntegrationGrpcService
//        extends BackOfficeIntegrationServiceGrpc.BackOfficeIntegrationServiceImplBase
//        implements BaseGrpcService, TraceHelper {
//    private final Tracer tracer;
//    private final BackOfficeIntegrationService backOfficeIntegrationService;
//
//    @Override
//    public void allowPrintingTicketByTicketCode(AllowPrintTicketCodeRequest request,
//                                                StreamObserver<AllowPrintTicketResponse> responseObserver) {
//        Span span = tracer.nextSpan(
//                TraceContextOrSamplingFlags.create(
//                        TraceIdContext.newBuilder()
//                                .traceId(toLong(
//                                        Optional.of(request.getMetadata())
//                                                .map(Common.RequestMetadata::getRequestId)
//                                                .orElse("1")
//                                ))
//                                .build()
//                )
//        );
//        StopWatch stopWatch = start(Constants.ID_TICKET_ALLOW_REPRINT_GRPC);
//        Common.SingleResponseMetadata responseMetadata = Common.SingleResponseMetadata.newBuilder()
//                .setRequestId(span.context().traceIdString())
//                .setTimestamp(System.currentTimeMillis())
//                .setResponseId(span.context().spanIdString())
//                .build();
//        try (Tracer.SpanInScope scopedSpan = tracer.withSpanInScope(span)) {
//            AllowPrintTicketResponse response = backOfficeIntegrationService.allowPrintingTicketWithTicketNumber(
//                    request, responseMetadata
//            );
//            responseObserver.onNext(response);
//        } catch (Exception e) {
//            log.error("Error occurred: ", e);
//            responseObserver.onNext(
//                    AllowPrintTicketResponse.newBuilder()
//                            .setMetadata(responseMetadata)
//                            .setSuccess(false)
//                            .setError(Common.Error.newBuilder()
//                                    .setCode("TCT:000000")
//                                    .setDescription("Unknown error occurred, please check ticket id.")
//                                    .setReason("Unknown error occurred.")
//                                    .build())
//                            .build()
//            );
//        } finally {
//            stop(stopWatch);
//            span.finish();
//            responseObserver.onCompleted();
//        }
//    }
//
//}


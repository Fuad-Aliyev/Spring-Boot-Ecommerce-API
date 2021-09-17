//package com.sf_ecommerce.fncom.config;
//
//import com.sf_ecommerce.fncom.constraint.GrpcServerInterceptor;
//import com.sf_ecommerce.fncom.constraint.GrpcService;
//import com.sf_ecommerce.fncom.container.LoggingFactory;
//import com.sf_ecommerce.fncom.utils.LoggingService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Configuration;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;
//import java.io.IOException;
//import java.io.InputStream;
//import java.security.InvalidKeyException;
//import java.security.NoSuchAlgorithmException;
//import java.security.spec.InvalidKeySpecException;
//import java.util.Iterator;
//import java.util.List;
//
//@ConditionalOnProperty(
//        value = {"spring.grpc.server.enabled"},
//        havingValue = "true",
//        matchIfMissing = true
//)
//@Configuration
//public class GrpcServerConfiguration {
//    @Value("${spring.grpc.server.enabled:false}")
//    private Boolean enabled;
//    @Value("${spring.grpc.server.port:8080}")
//    private Integer port;
//    @Value("${spring.grpc.server.ssl.pub.cert:}")
//    private String publicCertificateFile;
//    @Value("${spring.grpc.server.ssl.prv.cert:}")
//    private String privateCertificateFile;
//    @Value("${spring.grpc.server.ssl.prv.cert.type:RSA}")
//    private String privateCertificateType;
//    @Value("${spring.grpc.server.ssl.prv.cert.password:}")
//    private String privateCertificatePassword;
//    @Autowired(
//            required = false
//    )
//    @GrpcServerInterceptor
//    private ServerInterceptor serverInterceptor;
//    @Autowired(
//            required = false
//    )
//    @GrpcService
//    private List<Object> services;
//    private Server server;
//    private static final LoggingService LOG = LoggingFactory.of(GrpcServerConfiguration.class);
//
//    public GrpcServerConfiguration() {
//    }
//
//    @PostConstruct
//    public void init() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException {
//        if (this.enabled) {
//            LOG.infoLog("GRPC server will start on port: {}", new Object[]{this.port});
//            ServerBuilder<?> serverBuilder = ServerBuilder.forPort(this.port);
//            if (this.publicCertificateFile != null && !this.publicCertificateFile.isEmpty() && this.privateCertificateFile != null && !this.privateCertificateFile.isEmpty()) {
//                LOG.infoLog("GRPC SSL security is enabled with public: {} and private: {} certificates", new Object[]{this.publicCertificateFile, this.privateCertificateFile});
//                ClassLoader classLoader = this.getClass().getClassLoader();
//                InputStream publicKeyStream = classLoader.getResourceAsStream(this.publicCertificateFile);
//                InputStream privateKeyStream = classLoader.getResourceAsStream(this.privateCertificateFile);
//                if (this.privateCertificatePassword != null && !this.privateCertificatePassword.isEmpty()) {
//                    SslContext var5 = SslContextBuilder.forServer(publicKeyStream, privateKeyStream, this.privateCertificatePassword).sslProvider(SslProvider.OPENSSL).build();
//                } else {
//                    serverBuilder = serverBuilder.useTransportSecurity(publicKeyStream, privateKeyStream);
//                }
//            }
//
//            if (this.serverInterceptor != null) {
//                LOG.infoLog("GRPC Server interceptor added {}", new Object[]{this.serverInterceptor.getClass()});
//                serverBuilder = serverBuilder.intercept(this.serverInterceptor);
//            }
//
//            if (this.services != null) {
//                Iterator var6 = this.services.iterator();
//
//                while(var6.hasNext()) {
//                    Object object = var6.next();
//                    if (object instanceof BindableService) {
//                        BindableService bindableService = (BindableService)object;
//                        LOG.infoLog("GRPC service added {}", new Object[]{bindableService.getClass()});
//                        serverBuilder = serverBuilder.addService(bindableService);
//                    } else {
//                        LOG.warnLog("GRPC service {} is not child of BindableService class", new Object[]{object.getClass()});
//                    }
//                }
//            }
//
//            this.server = serverBuilder.build();
//            this.server.start();
//            LOG.infoLog("GRPC Server started");
//        } else {
//            LOG.infoLog("GRPC Server is not enabled");
//        }
//
//    }
//
//    @PreDestroy
//    public void close() {
//        if (this.enabled && this.server != null) {
//            this.server.shutdown();
//            LOG.infoLog("GRPC Server will shutdown");
//        }
//
//    }
//}
//

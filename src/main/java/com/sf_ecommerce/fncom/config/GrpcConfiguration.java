package com.sf_ecommerce.fncom.config;

import com.sf_ecommerce.fncom.utils.Constants;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile(Constants.GRPC_PROFILE)
@ImportAutoConfiguration(classes = GrpcServerConfiguration.class)
@Configuration
public class GrpcConfiguration {
}

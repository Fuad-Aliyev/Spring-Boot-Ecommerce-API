package com.sf_ecommerce.fncom.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sf_ecommerce.fncom.utils.LockingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.support.TransactionTemplate;

@Configuration
public class ApplicationConfiguration {
    @Primary
    @Bean(name = "json")
    public ObjectMapper defaultObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return objectMapper;
    }

//    @Bean(name = "xml")
//    public XmlMapper defaultXmlMapper() {
//        XmlMapper xmlMapper = new XmlMapper();
//        xmlMapper.registerModule(new JavaTimeModule());
//        xmlMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
//        return xmlMapper;
//    }


    @Bean
    public TaskExecutor threadPoolExecutor() {
        int availableCores = Runtime.getRuntime().availableProcessors();

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(availableCores);
        executor.setMaxPoolSize(availableCores);
        executor.setThreadNamePrefix("executor-srf");
        executor.initialize();
        return executor;
    }

    //primary bean
    @Bean
    public LockingService lockingService(TransactionTemplate transactionTemplate) {
        return new LockingService("ticket", transactionTemplate);
    }
}

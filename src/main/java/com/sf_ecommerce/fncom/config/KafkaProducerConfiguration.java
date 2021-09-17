package com.sf_ecommerce.fncom.config;

import com.sf_ecommerce.fncom.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.sf_ecommerce.fncom.utils.Constants.KAFKA_PRODUCER_KEY_MAX_REQUEST_SIZE;

@Profile({Constants.DEV_PROFILE, Constants.STAGING_PROFILE, Constants.PROD_PROFILE})
@Configuration
@RequiredArgsConstructor
public class KafkaProducerConfiguration {
    private final Environment environment;

    @Bean
    public Map<String, Object> producerConfigsForStringMessage() {
        Map<String, Object> props = new HashMap<>();
        props.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                environment.getRequiredProperty(Constants.KAFKA_KEY_BOOTSTRAP_SERVERS)
        );
        props.put(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                environment.getRequiredProperty(Constants.KAFKA_PRODUCER_KEY_STRING_KEY_DESERIALIZER_ID)
        );
        props.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                environment.getRequiredProperty(Constants.KAFKA_PRODUCER_KEY_STRING_VALUE_DESERIALIZER_ID)
        );
        Optional.ofNullable(environment.getProperty(KAFKA_PRODUCER_KEY_MAX_REQUEST_SIZE)).ifPresent(
                maxRequestSize -> props.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, maxRequestSize)
        );
        props.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                environment.getRequiredProperty(Constants.KAFKA_PRODUCER_KEY_STRING_VALUE_DESERIALIZER_ID)
        );
        return props;
    }

    @Bean
    public Map<String, Object> producerConfigsForByteArrayMessage() {
        Map<String, Object> props = new HashMap<>();
        props.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                environment.getRequiredProperty(Constants.KAFKA_KEY_BOOTSTRAP_SERVERS)
        );
        props.put(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                environment.getRequiredProperty(Constants.KAFKA_PRODUCER_KEY_STRING_KEY_DESERIALIZER_ID)
        );
        props.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                environment.getRequiredProperty(Constants.KAFKA_PRODUCER_KEY_BYTE_VALUE_DESERIALIZER_ID)
        );
        Optional.ofNullable(environment.getProperty(KAFKA_PRODUCER_KEY_MAX_REQUEST_SIZE)).ifPresent(
                maxRequestSize -> props.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, maxRequestSize)
        );
        return props;
    }

    @Bean
    public ProducerFactory<String, String> producerFactoryForStringMessage() {
        return new DefaultKafkaProducerFactory<>(producerConfigsForStringMessage());
    }

    @Bean
    public ProducerFactory<String, byte[]> producerFactoryForByteArrayMessage() {
        return new DefaultKafkaProducerFactory<>(producerConfigsForByteArrayMessage());
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactoryForStringMessage());
    }

    @Bean
    public KafkaTemplate<String, byte[]> kafkaTemplateForByteArrayMessage() {
        return new KafkaTemplate<>(producerFactoryForByteArrayMessage());
    }
}


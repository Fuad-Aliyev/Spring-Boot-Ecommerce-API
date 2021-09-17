package com.sf_ecommerce.fncom.config;

import com.sf_ecommerce.fncom.utils.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.TopicPartition;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.*;
import org.springframework.util.backoff.FixedBackOff;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Profile({Constants.DEV_PROFILE, Constants.STAGING_PROFILE, Constants.PROD_PROFILE})
@Configuration
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumerConfiguration {
    private final Environment environment;
    private final KafkaTopicConfiguration kafkaTopicConfiguration;
    private final KafkaTemplate<String, String> kafkaStrStrTemplate;
    private final KafkaTemplate<String, byte[]> kafkaStrByteTemplate;

    public Map<String, Object> consumerDefaultProperties() {
        Map<String, Object> props = new HashMap<>();
        props.put(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                environment.getRequiredProperty(Constants.KAFKA_KEY_BOOTSTRAP_SERVERS)
        );
        props.put(
                ConsumerConfig.GROUP_ID_CONFIG,
                environment.getRequiredProperty(Constants.KAFKA_CONSUMER_KEY_GROUP_ID)
        );
        props.put(
                ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,
                environment.getRequiredProperty(Constants.KAFKA_CONSUMER_KEY_AUTO_OFFSET_RESET)
        );
        props.put(
                ConsumerConfig.MAX_POLL_RECORDS_CONFIG,
                environment.getRequiredProperty(Constants.KAFKA_CONSUMER_KEY_MAX_POLL)
        );
        props.put(
                ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,
                environment.getRequiredProperty(Constants.KAFKA_CONSUMER_KEY_ENABLE_AUTO_COMMIT)
        );
        return props;
    }

    public Map<String, Object> consumerStringStringProperties() {
        Map<String, Object> props = consumerDefaultProperties();
        props.put(
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                environment.getRequiredProperty(Constants.KAFKA_CONSUMER_KEY_STRING_KEY_DESERIALIZER_ID)
        );
        props.put(
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                environment.getRequiredProperty(Constants.KAFKA_CONSUMER_KEY_STRING_VALUE_DESERIALIZER_ID)
        );
        return props;
    }

    public Map<String, Object> consumerStringByteProperties() {
        Map<String, Object> props = consumerDefaultProperties();
        props.put(
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                environment.getRequiredProperty(Constants.KAFKA_CONSUMER_KEY_STRING_KEY_DESERIALIZER_ID)
        );
        props.put(
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                environment.getRequiredProperty(Constants.KAFKA_CONSUMER_KEY_BYTE_VALUE_DESERIALIZER_ID)
        );
        return props;
    }

//    @Bean(Constants.BEAN_CONSUMER_FACTORY_STRING_STRING_NAME)
//    public ConsumerFactory<String, String> consumerStringStringFactory() {
//        return new DefaultKafkaConsumerFactory<>(consumerStringStringProperties());
//    }

//    @Profile({
//            Constants.PRE_MATCH_PROFILE,
//            Constants.LIVE_PROFILE
//    })
//    @Bean(Constants.BEAN_KAFKA_LISTENER_FEED_NAME)
//    public ConcurrentMessageListenerContainer<String, byte[]> feedListener(
//            @Qualifier(Constants.BEAN_CONSUMER_FACTORY_STRING_BYTE_NAME)
//                    ConsumerFactory<String, byte[]> consumerFactory,
//            @Qualifier(Constants.BEAN_KAFKA_CONSUMER_FEED_NAME)
//                    FeedConsumerService feedConsumerService
//    ) {
//        Integer concurrency = Math.max(
//                environment.getProperty(
//                        Constants.KAFKA_CONSUMER_KEY_FEED_CONCURRENCY,
//                        Integer.class,
//                        1
//                ), 1
//        );
//        ConcurrentKafkaListenerContainerFactory<String, byte[]> listenerContainerFactory =
//                new ConcurrentKafkaListenerContainerFactory<>();
//        listenerContainerFactory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
//        listenerContainerFactory.setConcurrency(concurrency);
//        listenerContainerFactory.setConsumerFactory(consumerFactory);
//        ConcurrentMessageListenerContainer<String, byte[]> container = listenerContainerFactory
//                .createContainer(kafkaTopicConfiguration.getTopicName(Constants.ENV_KEY_FEED_TOPIC_NAME));
//        container.setAutoStartup(true);
//        container.setBeanName(Constants.ID_FEED);
//        container.setupMessageListener(feedConsumerService);
//        container.setErrorHandler(defaultErrorHandler(kafkaStrByteTemplate));
//        return container;
//    }


    private ErrorHandler defaultErrorHandler(KafkaTemplate<?, ?> kafkaTemplate) {
        return new SeekToCurrentErrorHandler(
                new DeadLetterPublishingRecoverer(
                        kafkaTemplate,
                        (data, e) -> {
                            log.error("Error occurred topic {}, timestamp: {}", data.topic(), data.timestamp());
                            log.error("Details: ", e);
                            return new TopicPartition(data.topic().concat(".DLQ"), -1);
                        }), new FixedBackOff(100, 3)
        );
    }
}


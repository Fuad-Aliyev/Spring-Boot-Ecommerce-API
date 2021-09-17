package com.sf_ecommerce.fncom.config;

import com.sf_ecommerce.fncom.utils.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.EnumerablePropertySource;
import org.springframework.core.env.Environment;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.stream.StreamSupport;

@Profile({Constants.DEV_PROFILE, Constants.STAGING_PROFILE, Constants.PROD_PROFILE})
@Configuration
@Slf4j
@RequiredArgsConstructor
public class KafkaTopicConfiguration {
    private final Environment env;
    private final ConfigurableApplicationContext ctx;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @PostConstruct
    public void init() {
        String clearTopic = env.getProperty("default.kafka.config.topic.clear", "");
        try (AdminClient adminClient = AdminClient.create(kafkaAdmin().getConfig())) {
            StreamSupport.stream(
                    ctx.getEnvironment().getPropertySources().spliterator(), false)
                    .filter(ps -> ps instanceof EnumerablePropertySource)
                    .map(ps -> ((EnumerablePropertySource) ps).getPropertyNames())
                    .flatMap(Arrays::stream)
                    .filter(s -> s != null && s.startsWith("default.kafka.topic"))
                    .forEach(
                            propName -> {
                                NewTopic newTopic = createTopic(Objects.requireNonNull(env.getProperty(propName)));
                                if (!clearTopic.isEmpty()) {
                                    try {
                                        adminClient.deleteTopics(Collections.singletonList(newTopic.name())).all().get();
                                    } catch (InterruptedException | ExecutionException e) {
                                        log.error("Interrupted when deleting topics", e);
                                    }
                                }
                                ctx.getBeanFactory().registerSingleton(
                                        propName,
                                        newTopic
                                );
                                int currentPartitionSize = kafkaTemplate.partitionsFor(newTopic.name()).size();
                                log.info(
                                        "Topic property found. Key: {}, Value: {}. " +
                                                "(Partition size: {} | replication factor: {} | current partition size: {})",
                                        propName,
                                        newTopic.name(),
                                        newTopic.numPartitions(),
                                        newTopic.replicationFactor(),
                                        currentPartitionSize
                                );
                            }
                    );
        }
    }

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(
                AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,
                env.getRequiredProperty(Constants.ENV_KEY_KAFKA_BOOTSTRAP_SERVERS_NAME)
        );
        return new KafkaAdmin(configs);
    }

    private NewTopic createTopic(String name) {
        String[] split = name.split(":");
        TopicBuilder topicBuilder = TopicBuilder
                .name(split[0])
                .partitions(
                        env.getProperty(
                                Constants.ENV_KEY_KAFKA_PARTITIONS_SIZE,
                                Integer.class,
                                1
                        )
                ).replicas(
                        env.getProperty(
                                Constants.ENV_KEY_KAFKA_REPLICATION_FACTOR,
                                Integer.class,
                                1
                        )
                );
        switch (split.length) {
            case 3:
                int replicationFactor = Integer.parseInt(split[2]);
                topicBuilder.replicas(replicationFactor);
            case 2:
                int partitionSize = Integer.parseInt(split[1]);
                topicBuilder.partitions(partitionSize);
        }
        return topicBuilder.build();
    }

    public String getTopicName(String name) {
        String topicDetails = env.getRequiredProperty(name);
        String[] split = topicDetails.split(":");
        return split[0];
    }
}


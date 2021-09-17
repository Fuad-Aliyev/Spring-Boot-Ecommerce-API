package com.sf_ecommerce.fncom.utils;

public class Constants {
    //Profiles
    public static final String GRPC_PROFILE = "grpc";
    public static final String LIVE_PROFILE = "live";
    public static final String PRE_MATCH_PROFILE = "prematch";

    public static final String PROD_PROFILE = "production";
    public static final String DEV_PROFILE = "development";
    public static final String STAGING_PROFILE = "staging";
    public static final String TEST_PROFILE = "test";
    public static final String LOCAL_PROFILE = "local";

    public static final String GROUP_THREAD_EXECUTOR = "thread-executor";

    //Kafka & monitoring params
    public static final String HEADER_KEY_TRACE_ID = "x-trace-id";
    public static final String HEADER_KEY_TICKET_CHANGE_TYPE = "x-ticket-change-id";
    public static final String HEADER_KEY_FEED_TYPE = "x-feed-type-id";
    public static final String HEADER_KEY_RISK_OPERATION_TYPE_TYPE = "x-risk-op-subject-id";

    public static final String GROUP_KAFKA_CONSUMER = "kafka-consumer-group";

    public static final String KAFKA_KEY_BOOTSTRAP_SERVERS = "kafka.bootstrap-servers";
    public static final String KAFKA_CONSUMER_KEY_GROUP_ID = "kafka.consumer.group-id";
    public static final String KAFKA_CONSUMER_KEY_AUTO_OFFSET_RESET = "kafka.consumer.auto-offset-reset";
    public static final String KAFKA_CONSUMER_KEY_BYTE_KEY_DESERIALIZER_ID =
            "kafka.consumer.byte-array-key-deserializer";
    public static final String KAFKA_CONSUMER_KEY_BYTE_VALUE_DESERIALIZER_ID =
            "kafka.consumer.byte-array-value-deserializer";
    public static final String KAFKA_CONSUMER_KEY_STRING_KEY_DESERIALIZER_ID = "kafka.consumer.string-key-deserializer";
    public static final String KAFKA_CONSUMER_KEY_STRING_VALUE_DESERIALIZER_ID =
            "kafka.consumer.string-value-deserializer";
    public static final String KAFKA_CONSUMER_KEY_FEED_CONCURRENCY = "kafka.consumer.feed.concurrency";
    public static final String KAFKA_CONSUMER_KEY_TICKET_UPDATE_CONCURRENCY =
            "kafka.consumer.ticket-updater.concurrency";
    public static final String KAFKA_CONSUMER_KEY_MAX_POLL = "kafka.consumer.max.poll.records";
    public static final String KAFKA_CONSUMER_KEY_ENABLE_AUTO_COMMIT = "kafka.consumer.enable-auto-commit";


    public static final String KAFKA_PRODUCER_KEY_BYTE_KEY_DESERIALIZER_ID = "kafka.producer.byte-array-key-serializer";
    public static final String KAFKA_PRODUCER_KEY_BYTE_VALUE_DESERIALIZER_ID =
            "kafka.producer.byte-array-value-serializer";
    public static final String KAFKA_PRODUCER_KEY_STRING_KEY_DESERIALIZER_ID = "kafka.producer.string-key-serializer";
    public static final String KAFKA_PRODUCER_KEY_STRING_VALUE_DESERIALIZER_ID =
            "kafka.producer.string-value-serializer";
    public static final String KAFKA_PRODUCER_KEY_MAX_REQUEST_SIZE = "kafka.producer.max.request.size";

    public static final String ENV_KEY_KAFKA_BOOTSTRAP_SERVERS_NAME = "kafka.bootstrap-servers";
    public static final String ENV_KEY_KAFKA_ACKNOWLEDGE_LEVEL = "spring.kafka.producer.acks";
    public static final String ENV_KEY_KAFKA_PARTITIONS_SIZE = "default.kafka.config.topic.partitions";
    public static final String ENV_KEY_KAFKA_REPLICATION_FACTOR = "default.kafka.config.topic.replicas";

    public static final String ID_FEED = "ts_f";
    public static final String ID_BET_CANCEL = "f_ticket_bc";
    public static final String ID_ROLLBACK_BET_CANCEL = "f_ticket_rbc";
    public static final String ID_BET_SETTLEMENT = "f_ticket_bs";
    public static final String ID_ROLLBACK_BET_SETTLEMENT = "f_ticket_rbs";
    public static final String ID_TICKET_UPDATE = "t_ticket_update";
}

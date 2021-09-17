package com.sf_ecommerce.fncom.container;

import java.io.Serializable;

public interface KafkaProducer<K extends Serializable, V extends Serializable, M> extends BaseProducer {
    K send(M message);
}

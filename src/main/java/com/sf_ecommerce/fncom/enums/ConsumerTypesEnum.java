package com.sf_ecommerce.fncom.enums;

import com.sf_ecommerce.fncom.utils.Constants;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ConsumerTypesEnum {
    FEED_TYPE(Constants.ID_FEED),
    TICKET_UPDATE_CONSUMER(Constants.ID_TICKET_UPDATE),
    OTHERS("OTHERS"),
    ;

    private final String name;
}


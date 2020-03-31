package com.sf_ecommerce.fncom.dto.request.update;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Validated
public class MetafieldUpdateDTO implements Serializable {

    private static final long serialVersionUID = 1499426303231729232L;

    private String key;
    private String namespace;
    private String value;
    @JsonProperty("value_type")
    private String valueType;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    @Override
    public String toString() {
        return "MetafieldDTO{" +
                "key='" + key + '\'' +
                ", namespace='" + namespace + '\'' +
                ", value='" + value + '\'' +
                ", valueType='" + valueType + '\'' +
                '}';
    }
}

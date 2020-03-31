package com.sf_ecommerce.fncom.dto.request.create;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Validated
public class MetafieldDTO implements Serializable {

    private static final long serialVersionUID = 4152381779034657253L;

    @NotBlank(message = "key can not be empty")
    private String key;

    @NotBlank(message = "namespace can not be empty")
    private String namespace;

    @NotBlank(message = "value can not be empty")
    private String value;

    @JsonProperty("value_type")
    @NotBlank(message = "value_type can not empty")
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

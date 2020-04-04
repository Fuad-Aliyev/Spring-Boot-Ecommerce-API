package com.sf_ecommerce.fncom.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "META_FIELDS")
@DynamicInsert
@DynamicUpdate
public class MetafieldEntity  implements Serializable{

    private static final long serialVersionUID = -5977593271490438675L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "KYS")
    private String kys;

    @Column(name = "NAME_SPACE")
    private String nameSpace;

    @Column(name = "VALUE")
    private String value;

    @Column(name = "VALUE_TYPE")
    private String valueType;

    @NotFound(action = NotFoundAction.IGNORE)
    @OneToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private CustomerEntity customerEntity;



    public Long getId() {
        return id;
    }


    public String getKys() {
        return kys;
    }

    public void setKys(String kys) {
        this.kys = kys;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getNameSpace() {
        return nameSpace;
    }

    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }

    @Override
    public String toString() {
        return "MetafieldEntity{" +
                "id=" + id +
                ", kys='" + kys + '\'' +
                ", nameSpace='" + nameSpace + '\'' +
                ", value='" + value + '\'' +
                ", valueType='" + valueType + '\'' +
                '}';
    }
}

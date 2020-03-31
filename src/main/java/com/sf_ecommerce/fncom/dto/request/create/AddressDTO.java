package com.sf_ecommerce.fncom.dto.request.create;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sf_ecommerce.fncom.constant.ErrorConstantMessage;
import com.sf_ecommerce.fncom.constraint.OnlyInteger;
import com.sf_ecommerce.fncom.constraint.Phone;
import com.sf_ecommerce.fncom.entities.CustomerEntity;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Validated
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDTO implements Serializable {

    private static final long serialVersionUID = 4950035456448326299L;

    @NotBlank(message = "")
    private String firstName;

    @NotBlank(message = "")
    private String lastName;

    @NotBlank(message = "")
    private String company;

    @NotBlank(message = "")
    private String address1;

    @NotBlank(message = "")
    private String address2;

    @NotBlank(message = "")
    private String city;

    @NotNull(message = "")
    private String province;

    @NotBlank(message = "")
    private String country;

    @NotBlank(message = "")
    private String zipCode;

    @NotBlank(message = "")
    private String phone;

    @NotNull(message = "")
    private String provinceCode;

    @NotBlank(message = "")
    private String countryCode;

    @NotBlank(message = "")
    private String countryName;

    @NotNull(message = "")
    private Boolean defaultValue;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Boolean getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Boolean defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public String toString() {
        return "AddressEntity{" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", company='" + company + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", phone='" + phone + '\'' +
                ", provinceCode='" + provinceCode + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", countryName='" + countryName + '\'' +
                ", defaultValue=" + defaultValue +
                '}';
    }
}

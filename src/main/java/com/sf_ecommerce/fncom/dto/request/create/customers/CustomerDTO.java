package com.sf_ecommerce.fncom.dto.request.create.customers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sf_ecommerce.fncom.constraint.Email;
import com.sf_ecommerce.fncom.enums.TaxExemptionEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Validated
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(description = "All details about customer")
public class CustomerDTO implements Serializable {

    private static final long serialVersionUID = -5214416748031082083L;

    @ApiModelProperty(notes = "it is boolean that accepts marketing")
    @NotBlank(message = "acceptsMarketing can not be empty")
    private String acceptsMarketing;

    @Size(min = 1, max = 2, message = "addresses list can have min 1 max 2 addresses")
    @Valid
    @ApiModelProperty(notes = "It is address list of customer")
    private List<AddressDTO> addresses;

    @NotBlank(message = "currency can not be empty")
    @ApiModelProperty(notes = "it is currency that customer will pay")
    private String currency;

    @NotBlank(message = "email can not be empty")
    @Email
    @ApiModelProperty(notes = "It is email address of customer")
    private String email;

    @NotBlank(message = "firstname can not be empty")
    @ApiModelProperty(notes = "It is firstname of customer")
    private String firstName;

    @NotBlank(message = "lastname can not be empty")
    @ApiModelProperty(notes = "It is lastname of customer")
    private String lastName;

    @NotBlank(message = "lastOrderName can not be empty")
    @ApiModelProperty(notes = "It is name of the order that customer sent")
    private String lastOrderName;

    @Valid
    private MetafieldDTO metafield;

    @NotBlank(message = "marketingOptInLevel can not be empty")
    private String marketingOptInLevel;

    @NotBlank(message = "multipassIdentifier can not be empty")
    private String multipassIdentifier;

    @NotBlank(message = "note can not be empty")
    private String note;

    @NotNull(message = "ordersCount can not be empty")
    private BigInteger ordersCount;

    @NotBlank(message = "phone can not be empty")
    private String phone;

    @NotBlank(message = "state can not be empty")
    private String state;

    @NotBlank(message = "tags can not be empty")
    private String tags;

    @NotNull(message = "taxExempt can not be empty")
    private Boolean taxExempt;

    @Size(min = 1, max = 4, message = "taxExemptions can have min one and max one")
    private List<TaxExemptionEnum> taxExemptions;

    @NotNull(message = "totalSpend can not be null")
    private BigDecimal totalSpend;

    @NotNull(message = "verifiedEmail can not be null")
    private String verifiedEmail;

    public String getAcceptsMarketing() {
        return acceptsMarketing;
    }

    public void setAcceptsMarketing(String acceptsMarketing) {
        this.acceptsMarketing = acceptsMarketing;
    }

    public List<AddressDTO> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressDTO> addresses) {
        this.addresses = addresses;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public String getLastOrderName() {
        return lastOrderName;
    }

    public void setLastOrderName(String lastOrderName) {
        this.lastOrderName = lastOrderName;
    }

    public MetafieldDTO getMetafield() {
        return metafield;
    }

    public void setMetafield(MetafieldDTO metafield) {
        this.metafield = metafield;
    }

    public String getMarketingOptInLevel() {
        return marketingOptInLevel;
    }

    public void setMarketingOptInLevel(String marketingOptInLevel) {
        this.marketingOptInLevel = marketingOptInLevel;
    }

    public String getMultipassIdentifier() {
        return multipassIdentifier;
    }

    public void setMultipassIdentifier(String multipassIdentifier) {
        this.multipassIdentifier = multipassIdentifier;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public BigInteger getOrdersCount() {
        return ordersCount;
    }

    public void setOrdersCount(BigInteger ordersCount) {
        this.ordersCount = ordersCount;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Boolean getTaxExempt() {
        return taxExempt;
    }

    public void setTaxExempt(Boolean taxExempt) {
        this.taxExempt = taxExempt;
    }

    public List<TaxExemptionEnum> getTaxExemptions() {
        return taxExemptions;
    }

    public void setTaxExemptions(List<TaxExemptionEnum> taxExemptions) {
        this.taxExemptions = taxExemptions;
    }

    public BigDecimal getTotalSpend() {
        return totalSpend;
    }

    public void setTotalSpend(BigDecimal totalSpend) {
        this.totalSpend = totalSpend;
    }

    public String getVerifiedEmail() {
        return verifiedEmail;
    }

    public void setVerifiedEmail(String verifiedEmail) {
        this.verifiedEmail = verifiedEmail;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                ", acceptsMarketing='" + acceptsMarketing + '\'' +
                ", addresses=" + addresses +
                ", currency='" + currency + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", lastOrderName='" + lastOrderName + '\'' +
                ", metafield=" + metafield +
                ", marketingOptInLevel='" + marketingOptInLevel + '\'' +
                ", multipassIdentifier='" + multipassIdentifier + '\'' +
                ", note='" + note + '\'' +
                ", ordersCount=" + ordersCount +
                ", phone='" + phone + '\'' +
                ", state='" + state + '\'' +
                ", tags='" + tags + '\'' +
                ", taxExempt=" + taxExempt +
                ", taxExemptions=" + taxExemptions +
                ", totalSpend=" + totalSpend +
                ", verifiedEmail=" + verifiedEmail +
                '}';
    }
}

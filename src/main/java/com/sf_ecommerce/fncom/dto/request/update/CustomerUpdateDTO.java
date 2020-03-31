package com.sf_ecommerce.fncom.dto.request.update;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sf_ecommerce.fncom.constraint.Email;
import com.sf_ecommerce.fncom.dto.request.create.MetafieldDTO;
import com.sf_ecommerce.fncom.dto.response.AddressResponseDTO;
import com.sf_ecommerce.fncom.enums.TaxExemptionEnum;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Validated
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerUpdateDTO implements Serializable {

    private static final long serialVersionUID = 7640482777283240502L;

    private String acceptsMarketing;
    @Size(min = 1, max = 2, message = "addresses list can have min 1 max 2 addresses")
    @Valid
    private List<AddressUpdateDTO> addresses;
    private String currency;
    @Email
    private String email;
    private String firstName;
    private String lastName;
    private String lastOrderName;
    @Valid
    private MetafieldUpdateDTO metafield;
    private String marketingOptInLevel;
    private String multipassIdentifier;
    private String note;
    private BigInteger ordersCount;
    private String phone;
    private String state;
    private String tags;
    private Boolean taxExempt;
    @Size(min = 1, max = 4, message = "taxExemptions can have min one and max one")
    private List<TaxExemptionEnum> taxExemptions;
    private BigDecimal totalSpend;
    private String verifiedEmail;


    public String getAcceptsMarketing() {
        return acceptsMarketing;
    }

    public void setAcceptsMarketing(String acceptsMarketing) {
        this.acceptsMarketing = acceptsMarketing;
    }

    public List<AddressUpdateDTO> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressUpdateDTO> addresses) {
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

    public MetafieldUpdateDTO getMetafield() {
        return metafield;
    }

    public void setMetafield(MetafieldUpdateDTO metafield) {
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
        return "CustomerResponseDTO{" +
                "acceptsMarketing='" + acceptsMarketing + '\'' +
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

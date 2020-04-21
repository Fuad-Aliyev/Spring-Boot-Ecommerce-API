package com.sf_ecommerce.fncom.entities.customers;

import com.sf_ecommerce.fncom.enums.TaxExemptionEnum;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "CUSTOMERS")
@DynamicInsert
@DynamicUpdate
public class CustomerEntity implements Serializable {

    private static final long serialVersionUID = 2687485682307898221L;

    @Id
    @Basic
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq")
    @SequenceGenerator(name = "sq", sequenceName = "CUSTOMERS_SQ", allocationSize = 1)
    private Long id;

    @Column(name = "ACCEPTS_MARKETING")
    private String acceptsMarketing;

    @Column(name = "ACCEPT_MARKETING_UPDATING_AT")
    private Date acceptsmarketingUpdatingAt;

    @Column(name = "CURRENCY")
    private String currency;

    @Column(name = "CREATED_AT")
    @Temporal(TemporalType.DATE)
    private Date created_ad;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "LAST_ORDER_ID")
    private Long lastOrderId;

    @Column(name = "LAST_ORDER_NAME")
    private String lastOrderName;

    @NotFound(action = NotFoundAction.IGNORE)
    @OneToMany(mappedBy = "customerEntity", cascade = CascadeType.ALL)
    private List<AddressEntity> addressEntityList;

    @NotFound(action = NotFoundAction.IGNORE)
    @OneToOne(mappedBy = "customerEntity", cascade = CascadeType.ALL)
    private MetafieldEntity metafieldEntity;

    @Column(name = "MARKETING_OPT_IN_LEVEL")
    private String marketingOptInLevel;

    @Column(name = "MULTIPASS_IDENTIFIER")
    private String multipassIdentifier;

    @Column(name = "NOTE")
    private String note;

    @Column(name = "ORDERS_COUNT")
    private BigInteger ordersCount;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "STATE")
    private String state;

    @Column(name = "TAGS")
    private String tags;

    @Column(name = "TAX_EXEMPT")
    private Boolean taxExempt;

    @Column(name = "TAX_EXEMPTIONS")
    @Enumerated(EnumType.STRING)
    @ElementCollection
    @CollectionTable(name = "CUSTOMER_TAX_EXEMPTIONS", joinColumns = @JoinColumn(name = "CUSTOMER_ID"))
    private List<TaxExemptionEnum> taxExemptions;

    @Column(name = "TOTAL_SPEND")
    private BigDecimal totalSpend;

    @Column(name = "UPDATE_AT")
    @Temporal(TemporalType.DATE)
    private Date updatedAt;

    @Column(name = "VERIFIED_EMAIL")
    private String verifiedEmail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAcceptsMarketing() {
        return acceptsMarketing;
    }

    public void setAcceptsMarketing(String acceptsMarketing) {
        this.acceptsMarketing = acceptsMarketing;
    }

    public Date getAcceptsmarketingUpdatingAt() {
        return acceptsmarketingUpdatingAt;
    }

    public void setAcceptsmarketingUpdatingAt(Date acceptsmarketingUpdatingAt) {
        this.acceptsmarketingUpdatingAt = acceptsmarketingUpdatingAt;
    }

    public List<AddressEntity> getAddressEntityList() {
        return addressEntityList;
    }

    public void setAddressEntityList(List<AddressEntity> addressEntityList) {
        this.addressEntityList = addressEntityList;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getCreated_ad() {
        return created_ad;
    }

    public void setCreated_ad(Date created_ad) {
        this.created_ad = created_ad;
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

    public Long getLastOrderId() {
        return lastOrderId;
    }

    public void setLastOrderId(Long lastOrderId) {
        this.lastOrderId = lastOrderId;
    }

    public String getLastOrderName() {
        return lastOrderName;
    }

    public void setLastOrderName(String lastOrderName) {
        this.lastOrderName = lastOrderName;
    }

    public MetafieldEntity getMetafield() {
        return metafieldEntity;
    }

    public void setMetafield(MetafieldEntity metafieldEntity) {
        this.metafieldEntity = metafieldEntity;
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

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getVerifiedEmail() {
        return verifiedEmail;
    }

    public void setVerifiedEmail(String verifiedEmail) {
        this.verifiedEmail = verifiedEmail;
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}

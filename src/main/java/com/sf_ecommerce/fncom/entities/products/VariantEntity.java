package com.sf_ecommerce.fncom.entities.products;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Blob;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "VARIANTS")
@DynamicUpdate
@DynamicInsert
public class VariantEntity implements Serializable {

    private static final long serialVersionUID = -7512736516910765571L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "BAR_CODE")
    private String barCode;

    @Column(name = "COMPARE_AT_PRICE")
    private BigDecimal compareAtPrice;

    @Column(name = "CREATED_AT")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @Column(name = "FULFILLMENT_SERVICE")
    private String fulfillmentService;

    @Column(name = "GRAMS")
    private BigDecimal grams;

    @NotFound(action = NotFoundAction.IGNORE)
    @OneToOne(mappedBy = "variantEntity", cascade = CascadeType.PERSIST)
    private ImageEntity imageId;

    @Column(name = "INVENTORY_ITEM_ID")
    private Long inventoryItemId;

    @Column(name = "INVENTORY_MANAGEMENT")
    private String inventoryManagement;

    @Column(name = "INVENTORY_POLICY")
    private String inventoryPolicy;

    @Column(name = "INVENTORY_QUANTITY")
    private BigInteger inventoryQuantity;

    @Column(name = "OLD_INTENTORY_QUANTITY")
    private BigInteger oldInventoryQuantity;

    @Column(name = "INVENTORY_QUANTITY_ADJUSTMENT")
    private BigInteger inventoryQuantityAdjustment;

    @Column(name = "OPTION")
    private Blob option;

    @NotFound(action = NotFoundAction.IGNORE)
    @OneToMany(mappedBy = "variantEntity", cascade = CascadeType.ALL)
    private Set<PriceEntity> presentmentPrices;

    @Column(name = "POSITION")
    private Integer position;

    @Column(name = "PRICE")
    private BigDecimal price;

    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private ProductEntity productEntity;

    @Column(name = "REQUIRES_SHIPPING")
    private Boolean requiresShipping;

    @Column(name = "SKU")
    private String sku;

    @Column(name = "TAXABLE")
    private Boolean taxable;

    @Column(name = "TAX_CODE")
    private String taxCode;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "UPDATED_AT")
    @Temporal(TemporalType.DATE)
    private Date updatedAt;

    @Column(name = "WEIGHT")
    private BigDecimal weight;

    @Column(name = "WEIGHT_UNIT")
    private String weightUnit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public BigDecimal getCompareAtPrice() {
        return compareAtPrice;
    }

    public void setCompareAtPrice(BigDecimal compareAtPrice) {
        this.compareAtPrice = compareAtPrice;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getFulfillmentService() {
        return fulfillmentService;
    }

    public void setFulfillmentService(String fulfillmentService) {
        this.fulfillmentService = fulfillmentService;
    }

    public BigDecimal getGrams() {
        return grams;
    }

    public void setGrams(BigDecimal grams) {
        this.grams = grams;
    }

    public ImageEntity getImageId() {
        return imageId;
    }

    public void setImageId(ImageEntity imageId) {
        this.imageId = imageId;
    }

    public Long getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(Long inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public String getInventoryManagement() {
        return inventoryManagement;
    }

    public void setInventoryManagement(String inventoryManagement) {
        this.inventoryManagement = inventoryManagement;
    }

    public String getInventoryPolicy() {
        return inventoryPolicy;
    }

    public void setInventoryPolicy(String inventoryPolicy) {
        this.inventoryPolicy = inventoryPolicy;
    }

    public BigInteger getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(BigInteger inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }

    public BigInteger getOldInventoryQuantity() {
        return oldInventoryQuantity;
    }

    public void setOldInventoryQuantity(BigInteger oldInventoryQuantity) {
        this.oldInventoryQuantity = oldInventoryQuantity;
    }

    public BigInteger getInventoryQuantityAdjustment() {
        return inventoryQuantityAdjustment;
    }

    public void setInventoryQuantityAdjustment(BigInteger inventoryQuantityAdjustment) {
        this.inventoryQuantityAdjustment = inventoryQuantityAdjustment;
    }

    public Blob getOption() {
        return option;
    }

    public void setOption(Blob option) {
        this.option = option;
    }

    public Set<PriceEntity> getPresentmentPrices() {
        return presentmentPrices;
    }

    public void setPresentmentPrices(Set<PriceEntity> presentmentPrices) {
        this.presentmentPrices = presentmentPrices;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public Boolean getRequiresShipping() {
        return requiresShipping;
    }

    public void setRequiresShipping(Boolean requiresShipping) {
        this.requiresShipping = requiresShipping;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Boolean getTaxable() {
        return taxable;
    }

    public void setTaxable(Boolean taxable) {
        this.taxable = taxable;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    @Override
    public String toString() {
        return "VariantEntity{" +
                "id=" + id +
                ", sku='" + sku + '\'' +
                '}';
    }
}

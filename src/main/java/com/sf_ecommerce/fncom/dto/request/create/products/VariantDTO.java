package com.sf_ecommerce.fncom.dto.request.create.products;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sf_ecommerce.fncom.entities.products.ImageEntity;
import com.sf_ecommerce.fncom.entities.products.PriceEntity;
import com.sf_ecommerce.fncom.entities.products.ProductEntity;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Blob;
import java.util.Date;
import java.util.Set;

@Validated
@JsonInclude
public class VariantDTO implements Serializable {

    private static final long serialVersionUID = 6366237982445541482L;

    @NotBlank(message = "barCode in variant can not be empty")
    private String barCode;

    @NotNull(message = "compareAtPrice in variant can not be empty")
    private BigDecimal compareAtPrice;

    @NotBlank(message = "fulfillmentService in variant can not be empty")
    private String fulfillmentService;

    @NotNull(message = "grams in variant can not be empty")
    private BigDecimal grams;

    @Valid
    private ImageDTO images;

    @NotBlank(message = "inventoryManagement in variant can not be empty")
    private String inventoryManagement;

    @NotBlank(message = "inventoryPolicy in variant can not be empty")
    private String inventoryPolicy;

    @NotNull(message = "inventoryQuantity in variant can not be empty")
    private BigInteger inventoryQuantity;

    @NotNull(message = "oldInventoryQuantity in variant can not be empty")
    private BigInteger oldInventoryQuantity;

    @NotNull(message = "inventoryQuantityAdjustment in variant can not be empty")
    private BigInteger inventoryQuantityAdjustment;

    @Valid
    private OptionsDTO option;

    @Size(min = 1, max = 3, message = "presentmentPrices in variant can have min 1")
    @Valid
    private Set<PriceDTO> presentmentPrices;

    @NotNull(message = "position in variant can not be empty")
    private Integer position;

    @NotNull(message = "price in variant can not be empty")
    private BigDecimal price;

    @NotNull(message = "requiresShipping in variant can not be empty")
    private Boolean requiresShipping;

    @NotBlank(message = "sku in variant can not be empty")
    private String sku;

    @NotNull(message = "taxable in variant can not be empty")
    private Boolean taxable;

    @NotBlank(message = "taxCode in variant can not be empty")
    private String taxCode;

    @NotBlank(message = "title in variant can not be empty")
    private String title;

    @NotNull(message = "weight in variant can not be empty")
    private BigDecimal weight;

    @NotBlank(message = "weightUnit in variant can not be empty")
    private String weightUnit;

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

    public ImageDTO getImages() {
        return images;
    }

    public void setImages(ImageDTO images) {
        this.images = images;
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

    public OptionsDTO getOption() {
        return option;
    }

    public void setOption(OptionsDTO option) {
        this.option = option;
    }

    public Set<PriceDTO> getPresentmentPrices() {
        return presentmentPrices;
    }

    public void setPresentmentPrices(Set<PriceDTO> presentmentPrices) {
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
        return "VariantDTO{" +
                "barCode='" + barCode + '\'' +
                ", compareAtPrice=" + compareAtPrice +
                ", fulfillmentService='" + fulfillmentService + '\'' +
                ", grams=" + grams +
                ", images=" + images +
                ", inventoryManagement='" + inventoryManagement + '\'' +
                ", inventoryPolicy='" + inventoryPolicy + '\'' +
                ", inventoryQuantity=" + inventoryQuantity +
                ", oldInventoryQuantity=" + oldInventoryQuantity +
                ", inventoryQuantityAdjustment=" + inventoryQuantityAdjustment +
                ", option=" + option +
                ", presentmentPrices=" + presentmentPrices +
                ", position=" + position +
                ", price=" + price +
                ", requiresShipping=" + requiresShipping +
                ", sku='" + sku + '\'' +
                ", taxable=" + taxable +
                ", taxCode='" + taxCode + '\'' +
                ", title='" + title + '\'' +
                ", weight=" + weight +
                ", weightUnit='" + weightUnit + '\'' +
                '}';
    }
}

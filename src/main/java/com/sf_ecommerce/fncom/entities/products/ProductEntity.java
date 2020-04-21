package com.sf_ecommerce.fncom.entities.products;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "PRODUCTS")
@DynamicInsert
@DynamicUpdate
public class ProductEntity implements Serializable {

    private static final long serialVersionUID = 7524666780684688429L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "BODY_HTML")
    private String bodyHtml;

    @Column(name = "CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "HANDLE")
    private String handle;

    @NotFound(action = NotFoundAction.IGNORE)
    @OneToMany(mappedBy = "productEntity", cascade = CascadeType.ALL)
    private Set<ImageEntity> images;

    @Column(name = "OPTIONS")
    private Blob options;

    @Column(name = "PRODUCT_TYPE")
    private String productType;

    @Column(name = "PUBLISHED_AT")
    private Date publishedAt;

    @Column(name = "PUBLISHED_SCOPE")
    private String publishedScope;

    @Column(name = "TAGS")
    private String tags;

    @Column(name = "TEMPLATE_SUFFIX")
    private String templateSuffix;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "UPDATED_AT")
    @Temporal(TemporalType.DATE)
    private Date updatedAt;

    @NotFound(action = NotFoundAction.IGNORE)
    @OneToMany(mappedBy = "productEntity", cascade = CascadeType.ALL)
    private Set<VariantEntity> variantEntitySet;

    @Column(name = "VENDOR")
    private String vendor;

    @NotFound(action = NotFoundAction.IGNORE)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "COLLECT_ID")
    private CollectEntity collectEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBodyHtml() {
        return bodyHtml;
    }

    public void setBodyHtml(String bodyHtml) {
        this.bodyHtml = bodyHtml;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public Set<ImageEntity> getImages() {
        return images;
    }

    public void setImages(Set<ImageEntity> images) {
        this.images = images;
    }

    public Blob getOptions() {
        return options;
    }

    public void setOptions(Blob options) {
        this.options = options;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getPublishedScope() {
        return publishedScope;
    }

    public void setPublishedScope(String publishedScope) {
        this.publishedScope = publishedScope;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTemplateSuffix() {
        return templateSuffix;
    }

    public void setTemplateSuffix(String templateSuffix) {
        this.templateSuffix = templateSuffix;
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

    public Set<VariantEntity> getVariantEntitySet() {
        return variantEntitySet;
    }

    public void setVariantEntitySet(Set<VariantEntity> variantEntitySet) {
        this.variantEntitySet = variantEntitySet;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}

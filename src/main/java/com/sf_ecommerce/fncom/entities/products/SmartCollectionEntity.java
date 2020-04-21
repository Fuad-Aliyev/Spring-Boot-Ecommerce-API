package com.sf_ecommerce.fncom.entities.products;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "SMART_COLLECTIONS")
@DynamicUpdate
@DynamicInsert
public class SmartCollectionEntity implements Serializable {

    private static final long serialVersionUID = -1304512666770942752L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "BODY_HTML")
    private String bodyHtml;

    @Column(name = "HANDLE")
    private String handle;

    @NotFound(action = NotFoundAction.IGNORE)
    @OneToOne(mappedBy = "smartCollectionEntity", cascade = CascadeType.ALL)
    private ImageEntity imageEntity;

    @Column(name = "PUBLISHED_AT")
    private Date publishedAt;

    @Column(name = "PUBLISHED_SCOPE")
    private String publishedScope;

    @Column(name = "DISJUNCTIVE")
    private Boolean disjunctive;

    @Column(name = "SORT_ORDER")
    private String sortOrder;

    @Column(name = "TEMPLATE_SUFFIX")
    private String templateSuffix;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "UPDATED_AT")
    private Date updatedAt;

    @Column(name = "PRODUCTS_MANUALLY_SORTED_COUNT")
    private BigInteger productsManuallySortedCount;

    @NotFound(action = NotFoundAction.IGNORE)
    @OneToOne(mappedBy = "smartCollectionEntity", cascade = CascadeType.ALL)
    private RuleEntity ruleEntity;

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

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public ImageEntity getImageEntity() {
        return imageEntity;
    }

    public void setImageEntity(ImageEntity imageEntity) {
        this.imageEntity = imageEntity;
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

    public Boolean getDisjunctive() {
        return disjunctive;
    }

    public void setDisjunctive(Boolean disjunctive) {
        this.disjunctive = disjunctive;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
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

    public BigInteger getProductsManuallySortedCount() {
        return productsManuallySortedCount;
    }

    public void setProductsManuallySortedCount(BigInteger productsManuallySortedCount) {
        this.productsManuallySortedCount = productsManuallySortedCount;
    }

    public RuleEntity getRuleEntity() {
        return ruleEntity;
    }

    public void setRuleEntity(RuleEntity ruleEntity) {
        this.ruleEntity = ruleEntity;
    }

    @Override
    public String toString() {
        return "SmartCollectionEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}

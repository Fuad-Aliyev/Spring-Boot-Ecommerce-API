package com.sf_ecommerce.fncom.entities.products;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

@Entity
@Table(name = "CUSTOM_COLLECTIONS")
@DynamicInsert
@DynamicUpdate
public class CustomCollectionEntity implements Serializable {

    private static final long serialVersionUID = 4370155802578303665L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "BODY_HTML")
    private String bodyHtml;

    @Column(name = "HANDLE")
    private String handle;

    @NotFound(action = NotFoundAction.IGNORE)
    @OneToOne(cascade = CascadeType.PERSIST)
    private ImageEntity image;

    @Column(name = "PUBLISHED")
    private Boolean published;

    @Column(name = "PUBLISHED_AT")
    @Temporal(TemporalType.DATE)
    private Date publishedAt;

    @Column(name = "PUBLISHED_SCOPE")
    private String publishedScope;

    @Column(name = "SORT_ORDER")
    private String sortOrder;

    @Column(name = "TEMPLATE_SUFFIX")
    private String templateSuffix;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "UPDATED_AT")
    @Temporal(TemporalType.DATE)
    private Date updatedAt;

    @NotFound(action = NotFoundAction.IGNORE)
    @OneToOne(mappedBy = "customCollectionEntity", cascade = CascadeType.ALL)
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

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public ImageEntity getImage() {
        return image;
    }

    public void setImage(ImageEntity image) {
        this.image = image;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
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

    public CollectEntity getCollectEntity() {
        return collectEntity;
    }

    public void setCollectEntity(CollectEntity collectEntity) {
        this.collectEntity = collectEntity;
    }

    @Override
    public String toString() {
        return "CustomCollectionEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}

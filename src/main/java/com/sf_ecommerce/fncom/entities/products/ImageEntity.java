package com.sf_ecommerce.fncom.entities.products;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

@Entity
@Table(name = "IMAGES")
public class ImageEntity implements Serializable {

    private static final long serialVersionUID = -9090580772017358772L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CREATED_AT")
    private Date createdAt;

    @Column(name = "POSITION")
    private Integer position;

    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PRODUCT_ID")
    private ProductEntity productEntity;

    @NotFound(action = NotFoundAction.IGNORE)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "VARIANT_ID")
    private VariantEntity variantEntity;

    @NotFound(action = NotFoundAction.IGNORE)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "COLLECTION_ID")
    private CollectionEntity collectionEntity;

    @NotFound(action = NotFoundAction.IGNORE)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOM_COLLECTION_ID")
    private CustomCollectionEntity customCollectionEntity;

    @NotFound(action = NotFoundAction.IGNORE)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SMART_COLLECTION_ID")
    private SmartCollectionEntity smartCollectionEntity;

    @Column(name = "SRC")
    private String src;

    @Column(name = "WIDTH")
    private Integer width;

    @Column(name = "HEIGHT")
    private Integer height;

    @Column(name = "UPDATED_AT")
    @Temporal(TemporalType.DATE)
    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public VariantEntity getVariantEntity() {
        return variantEntity;
    }

    public void setVariantEntity(VariantEntity variantEntity) {
        this.variantEntity = variantEntity;
    }

    public CollectionEntity getCollectionEntity() {
        return collectionEntity;
    }

    public void setCollectionEntity(CollectionEntity collectionEntity) {
        this.collectionEntity = collectionEntity;
    }

    public CustomCollectionEntity getCustomCollectionEntity() {
        return customCollectionEntity;
    }

    public void setCustomCollectionEntity(CustomCollectionEntity customCollectionEntity) {
        this.customCollectionEntity = customCollectionEntity;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public SmartCollectionEntity getSmartCollectionEntity() {
        return smartCollectionEntity;
    }

    public void setSmartCollectionEntity(SmartCollectionEntity smartCollectionEntity) {
        this.smartCollectionEntity = smartCollectionEntity;
    }

    @Override
    public String toString() {
        return "ImageEntity{" +
                "id=" + id +
                '}';
    }
}

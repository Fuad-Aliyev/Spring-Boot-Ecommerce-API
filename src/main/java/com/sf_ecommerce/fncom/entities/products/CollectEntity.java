package com.sf_ecommerce.fncom.entities.products;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "COLLECT")
@DynamicUpdate
@DynamicInsert
public class CollectEntity implements Serializable {

    private static final long serialVersionUID = -7283938476956037903L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CREATED_AT")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @NotFound(action = NotFoundAction.IGNORE)
    @OneToOne
    @JoinColumn(name = "CUSTOM_COLLECTION_ID")
    private CustomCollectionEntity customCollectionEntity;

    @Column(name = "POSITION")
    private Integer position;

    @Column(name = "SORT_VALUE")
    private String sortValue;

    @Column(name = "UPDATED_AT")
    @Temporal(TemporalType.DATE)
    private Date updatedAt;

    @NotFound(action = NotFoundAction.IGNORE)
    @OneToOne(mappedBy = "collectEntity", cascade = CascadeType.PERSIST)
    private ProductEntity productEntity;

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

    public CustomCollectionEntity getCustomCollectionEntity() {
        return customCollectionEntity;
    }

    public void setCustomCollectionEntity(CustomCollectionEntity customCollectionEntity) {
        this.customCollectionEntity = customCollectionEntity;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getSortValue() {
        return sortValue;
    }

    public void setSortValue(String sortValue) {
        this.sortValue = sortValue;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    @Override
    public String toString() {
        return "CollectEntity{" +
                "id=" + id +
                '}';
    }
}

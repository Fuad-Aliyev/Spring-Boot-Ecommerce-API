package com.sf_ecommerce.fncom.entities.products;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PRICES")
@DynamicInsert
@DynamicUpdate
public class PriceEntity implements Serializable {

    private static final long serialVersionUID = 1546188435980583210L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotFound(action = NotFoundAction.IGNORE)
    @OneToOne(mappedBy = "priceEntity", cascade = CascadeType.PERSIST)
    private PriceDetailEntity price;

    @NotFound(action = NotFoundAction.IGNORE)
    @OneToOne(mappedBy = "priceEntity", cascade = CascadeType.PERSIST)
    private PriceDetailEntity compareAtPrice;

    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "VARIANT_ID")
    private VariantEntity variantEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PriceDetailEntity getPrice() {
        return price;
    }

    public void setPrice(PriceDetailEntity price) {
        this.price = price;
    }

    public PriceDetailEntity getCompareAtPrice() {
        return compareAtPrice;
    }

    public void setCompareAtPrice(PriceDetailEntity compareAtPrice) {
        this.compareAtPrice = compareAtPrice;
    }

    public VariantEntity getVariantEntity() {
        return variantEntity;
    }

    public void setVariantEntity(VariantEntity variantEntity) {
        this.variantEntity = variantEntity;
    }

    @Override
    public String toString() {
        return "PriceEntity{" +
                "id=" + id +
                '}';
    }
}

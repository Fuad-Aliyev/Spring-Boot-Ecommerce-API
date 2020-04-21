package com.sf_ecommerce.fncom.entities.products;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PRICE_DETAILS")
@DynamicInsert
@DynamicUpdate
public class PriceDetailEntity implements Serializable {

    private static final long serialVersionUID = -4533558681228776434L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CURRENCY_CODE")
    private String currencyCode;

    @Column(name = "AMOUNT")
    private String amount;

    @NotFound(action = NotFoundAction.IGNORE)
    @OneToOne
    @JoinColumn(name = "PRICE_ID")
    private PriceEntity priceEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public PriceEntity getPriceEntity() {
        return priceEntity;
    }

    public void setPriceEntity(PriceEntity priceEntity) {
        this.priceEntity = priceEntity;
    }

    @Override
    public String toString() {
        return "PriceDetailEntity{" +
                "id=" + id +
                ", currencyCode='" + currencyCode + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}

package com.sf_ecommerce.fncom.entities.products;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "RULES")
@DynamicInsert
@DynamicUpdate
public class RuleEntity implements Serializable {

    private static final long serialVersionUID = 2978956234102363032L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "COLUMN")
    private String columnValue;

    @Column(name = "RELATION")
    private String relation;

    @Column(name = "CONDITION_VALUE")
    private String conditionValue;

    @NotFound(action = NotFoundAction.IGNORE)
    @OneToOne
    @JoinColumn(name = "SMART_COLLECTION_ID")
    private SmartCollectionEntity smartCollectionEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColumnValue() {
        return columnValue;
    }

    public void setColumnValue(String columnValue) {
        this.columnValue = columnValue;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getConditionValue() {
        return conditionValue;
    }

    public void setConditionValue(String conditionValue) {
        this.conditionValue = conditionValue;
    }

    public SmartCollectionEntity getSmartCollectionEntity() {
        return smartCollectionEntity;
    }

    public void setSmartCollectionEntity(SmartCollectionEntity smartCollectionEntity) {
        this.smartCollectionEntity = smartCollectionEntity;
    }

    @Override
    public String toString() {
        return "RuleEntity{" +
                "id=" + id +
                ", columnValue='" + columnValue + '\'' +
                '}';
    }
}

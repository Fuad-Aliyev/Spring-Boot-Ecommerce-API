package com.sf_ecommerce.fncom.entities;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "COLLECTIONS")
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

    @Column(name = "COLLECTION_ID")
    private Long collectionId;

    @Column(name = "POSITION")
    private Integer position;

    private Long productId;

    @Column(name = "SORT_VALUE")
    private String sortValue;

    @Column(name = "UPDATED_AT")
    @Temporal(TemporalType.DATE)
    private Date updatedAt;

    
}

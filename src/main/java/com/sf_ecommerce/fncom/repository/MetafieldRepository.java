package com.sf_ecommerce.fncom.repository;

import com.sf_ecommerce.fncom.entities.MetafieldEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetafieldRepository extends JpaRepository<MetafieldEntity, Long> {
}

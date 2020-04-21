package com.sf_ecommerce.fncom.repository;

import com.sf_ecommerce.fncom.entities.customers.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    List<AddressEntity> findByCountry(String country);
}

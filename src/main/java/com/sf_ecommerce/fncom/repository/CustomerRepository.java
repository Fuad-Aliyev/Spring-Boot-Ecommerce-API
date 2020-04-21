package com.sf_ecommerce.fncom.repository;

import com.sf_ecommerce.fncom.entities.customers.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    Optional<List<CustomerEntity>> findCustomerEntitiesByIdAfter(Long sinceId);
}

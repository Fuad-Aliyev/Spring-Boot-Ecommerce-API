package com.sf_ecommerce.fncom.repository;

import com.sf_ecommerce.fncom.entities.AddressEntity;
import com.sf_ecommerce.fncom.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedNativeQuery;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    Optional<List<CustomerEntity>> findCustomerEntitiesByIdAfter(Long sinceId);
}

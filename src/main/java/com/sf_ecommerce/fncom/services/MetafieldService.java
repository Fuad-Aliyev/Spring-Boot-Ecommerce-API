package com.sf_ecommerce.fncom.services;

import com.sf_ecommerce.fncom.entities.CustomerEntity;
import com.sf_ecommerce.fncom.entities.MetafieldEntity;
import com.sf_ecommerce.fncom.repository.MetafieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;

@Service
public class MetafieldService {

    @Autowired
    private MetafieldRepository metafieldRepository;

    public void updateMetafieldEntity(MetafieldEntity metafieldEntity, CustomerEntity customerEntity) {
        metafieldEntity.setCustomerEntity(customerEntity);
        metafieldRepository.save(metafieldEntity);
    }
}

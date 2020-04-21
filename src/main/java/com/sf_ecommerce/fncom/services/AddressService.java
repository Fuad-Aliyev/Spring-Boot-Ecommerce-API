package com.sf_ecommerce.fncom.services;

import com.sf_ecommerce.fncom.dto.request.create.customers.AddressDTO;
import com.sf_ecommerce.fncom.dto.request.update.AddressUpdateDTO;
import com.sf_ecommerce.fncom.entities.customers.AddressEntity;
import com.sf_ecommerce.fncom.entities.customers.CustomerEntity;
import com.sf_ecommerce.fncom.enums.ErrorEnum;
import com.sf_ecommerce.fncom.exceptions.RestException;
import com.sf_ecommerce.fncom.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CustomerService customerService;

    public void updateAddress(List<AddressEntity> addressEntityList, CustomerEntity customerEntity) {
        addressEntityList = addressEntityList.stream().map(addressEntity -> {
            addressEntity.setCustomerEntity(customerEntity);
            return addressEntity;
        }).collect(Collectors.toList());
        addressRepository.saveAll(addressEntityList);
    }

    public List<AddressEntity> getAddressEntitiesByCountry(String country) {
        return addressRepository.findByCountry(country);
    }

    public AddressEntity getAddressOfCustomerForAddressId(CustomerEntity customerEntity, Long addressId) {
        return customerEntity.getAddressEntityList()
                .stream()
                .filter(addressEntity -> addressEntity.getId() == addressId)
                .findFirst()
                .orElseThrow(() -> new RestException(ErrorEnum.ENTITY_NOT_FOUND));
    }

    public void deleteAddress(Long customerId, Long addressId) {
        CustomerEntity customerEntity = customerService.getCustomerEntityById(customerId);
        AddressEntity addressEntity = customerEntity.getAddressEntityList()
                            .stream()
                            .filter(addressEntity1 -> addressEntity1.getId() == addressId)
                            .findFirst()
                            .orElseThrow(() -> new RestException(ErrorEnum.ENTITY_NOT_FOUND));
        addressRepository.delete(addressEntity);
    }

    public AddressEntity createAddress(AddressDTO addressDTO, Long customerId) {
        CustomerEntity customerEntity = customerService.getCustomerEntityById(customerId);
        AddressEntity addressEntity = dtoToEntity(addressDTO, customerEntity);
        addressRepository.save(addressEntity);
        return addressEntity;
    }

    public AddressEntity updateAddress(AddressUpdateDTO addressUpdateDTO, Long addressId, Long customerId) {
        CustomerEntity customerEntity = customerService.getCustomerEntityById(customerId);
        AddressEntity addressEntity = customerEntity.getAddressEntityList()
                                    .stream()
                                    .filter(addressEntity1 -> addressEntity1.getId() == addressId)
                                    .findFirst()
                                    .orElseThrow(() -> new RestException(ErrorEnum.ENTITY_NOT_FOUND));
        addressEntity = dtoOnExistingEntity(addressEntity, addressUpdateDTO, customerEntity);
        addressRepository.save(addressEntity);
        return addressEntity;
    }

    public AddressEntity updateAddress(Long addressId, Long customerId) {
        CustomerEntity customerEntity = customerService.getCustomerEntityById(customerId);
        AddressEntity addressEntity = customerEntity.getAddressEntityList()
                .stream()
                .filter(addressEntity1 -> addressEntity1.getId() == addressId)
                .findFirst()
                .orElseThrow(() -> new RestException(ErrorEnum.ENTITY_NOT_FOUND));
        addressEntity.setDefaultValue(true);
        addressRepository.save(addressEntity);
        return addressEntity;
    }

    private AddressEntity dtoOnExistingEntity(AddressEntity addressEntity, AddressUpdateDTO addressDTO, CustomerEntity customerEntity) {
        addressEntity.setCity(addressDTO.getCity());
        addressEntity.setCountry(addressDTO.getCountry());
        addressEntity.setAddress1(addressDTO.getAddress1());
        addressEntity.setAddress2(addressDTO.getAddress2());
        addressEntity.setCompany(addressDTO.getCompany());
        addressEntity.setCountryCode(addressDTO.getCountryCode());
        addressEntity.setCountryName(addressDTO.getCountryName());
        addressEntity.setDefaultValue(addressDTO.getDefaultValue());
        addressEntity.setFirstName(addressDTO.getFirstName());
        addressEntity.setLastName(addressDTO.getLastName());
        addressEntity.setPhone(addressDTO.getPhone());
        addressEntity.setProvince(addressDTO.getProvince());
        addressEntity.setProvinceCode(addressDTO.getProvinceCode());
        addressEntity.setZipCode(addressDTO.getZipCode());
        addressEntity.setCustomerEntity(customerEntity);
        return addressEntity;
    }


    private AddressEntity dtoToEntity(AddressDTO addressDTO, CustomerEntity customerEntity) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setCity(addressDTO.getCity());
        addressEntity.setCountry(addressDTO.getCountry());
        addressEntity.setAddress1(addressDTO.getAddress1());
        addressEntity.setAddress2(addressDTO.getAddress2());
        addressEntity.setCompany(addressDTO.getCompany());
        addressEntity.setCountryCode(addressDTO.getCountryCode());
        addressEntity.setCountryName(addressDTO.getCountryName());
        addressEntity.setDefaultValue(addressDTO.getDefaultValue());
        addressEntity.setFirstName(addressDTO.getFirstName());
        addressEntity.setLastName(addressDTO.getLastName());
        addressEntity.setPhone(addressDTO.getPhone());
        addressEntity.setProvince(addressDTO.getProvince());
        addressEntity.setProvinceCode(addressDTO.getProvinceCode());
        addressEntity.setZipCode(addressDTO.getZipCode());
        addressEntity.setCustomerEntity(customerEntity);
        return addressEntity;
    }

}

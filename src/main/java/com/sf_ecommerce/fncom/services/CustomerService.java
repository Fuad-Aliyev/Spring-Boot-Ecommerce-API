package com.sf_ecommerce.fncom.services;

import com.sf_ecommerce.fncom.dto.request.create.CustomerDTO;
import com.sf_ecommerce.fncom.dto.request.update.CustomerUpdateDTO;
import com.sf_ecommerce.fncom.entities.AddressEntity;
import com.sf_ecommerce.fncom.entities.CustomerEntity;
import com.sf_ecommerce.fncom.entities.MetafieldEntity;
import com.sf_ecommerce.fncom.enums.ErrorEnum;
import com.sf_ecommerce.fncom.exceptions.RestException;
import com.sf_ecommerce.fncom.repository.CustomerRepository;
import com.sf_ecommerce.fncom.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressService addressService;

    @Autowired
    private MetafieldService metafieldService;

    public CustomerEntity saveCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity = createMapper(customerDTO, customerEntity);
        customerRepository.save(customerEntity);
        addressService.updateAddress(customerEntity.getAddressEntityList(), customerEntity);
        metafieldService.updateMetafieldEntity(customerEntity.getMetafield(), customerEntity);
        return customerEntity;
    }

    public CustomerEntity updateCustomer(CustomerUpdateDTO customerUpdateDTO, Long id) {
        CustomerEntity customerEntity = getCustomerEntityById(id);
        customerEntity = updateMapper(customerUpdateDTO, customerEntity);
        customerRepository.save(customerEntity);
        addressService.updateAddress(customerEntity.getAddressEntityList(), customerEntity);
        metafieldService.updateMetafieldEntity(customerEntity.getMetafield(), customerEntity);
        return customerEntity;
    }

    public CustomerEntity getCustomerEntityById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new RestException(ErrorEnum.ENTITY_NOT_FOUND));
    }

    public void deleteCustomerEntityById(Long id) {
        if (Objects.isNull(id))
            throw new RestException(ErrorEnum.ENTITY_NOT_FOUND);
        customerRepository.deleteById(id);
    }

    public List<CustomerEntity> getListOfCustomers(Long sinceId) {
        if (Objects.isNull(sinceId))
            throw new RestException(ErrorEnum.ENTITY_NOT_FOUND);
        return customerRepository.findCustomerEntitiesByIdAfter(sinceId)
                .orElseThrow(() -> new RestException(ErrorEnum.ENTITY_NOT_FOUND));
    }

    public List<CustomerEntity> getListOfCustomers(String counrty, Integer limit, Integer size) {
        if (Objects.isNull(counrty) || Objects.isNull(limit) || Objects.isNull(size))
            throw new RestException(ErrorEnum.ENTITY_NOT_FOUND);
        List<AddressEntity> addressEntityList = addressService
                .getAddressEntitiesByCountry(counrty).subList(limit, size);
        List<CustomerEntity> customerEntityList = addressEntityList.stream()
                .map(addressEntity -> {
                    CustomerEntity customerEntity = addressEntity.getCustomerEntity();
                    return customerEntity;
                }).collect(Collectors.toList());
        return customerEntityList;
    }

    public List<AddressEntity> getAddressesOfCustomer(Long customerId) {
        CustomerEntity customerEntity = getCustomerEntityById(customerId);
        return customerEntity.getAddressEntityList();
    }

    public Long getCountOfCustomers() {
        return customerRepository.count();
    }

    private CustomerEntity updateMapper(CustomerUpdateDTO customerUpdateDTO, CustomerEntity customerEntity) {
        List<AddressEntity> addressEntityList = getAddressUpdateList(customerUpdateDTO);

        MetafieldEntity metafieldEntity = new MetafieldEntity();
        metafieldEntity.setKys(customerUpdateDTO.getMetafield().getKey());
        metafieldEntity.setNameSpace(customerUpdateDTO.getMetafield().getNamespace());
        metafieldEntity.setValue(customerUpdateDTO.getMetafield().getValue());
        metafieldEntity.setValueType(customerUpdateDTO.getMetafield().getValueType());

        customerEntity.setAcceptsMarketing(customerUpdateDTO.getAcceptsMarketing());
        customerEntity.setAddressEntityList(addressEntityList);
        customerEntity.setCreated_ad(CommonUtils.convertLocalDateToDate(LocalDate.now()));
        customerEntity.setCurrency(customerUpdateDTO.getCurrency());
        customerEntity.setEmail(customerUpdateDTO.getEmail());
        customerEntity.setFirstName(customerUpdateDTO.getFirstName());
        customerEntity.setLastName(customerUpdateDTO.getLastName());
        customerEntity.setLastOrderId(Long.parseLong("12345"));
        customerEntity.setLastOrderName(customerUpdateDTO.getLastOrderName());
        customerEntity.setMarketingOptInLevel(customerUpdateDTO.getMarketingOptInLevel());
        customerEntity.setMetafield(metafieldEntity);
        customerEntity.setMultipassIdentifier(customerUpdateDTO.getMultipassIdentifier());
        customerEntity.setNote(customerUpdateDTO.getNote());
        customerEntity.setOrdersCount(customerUpdateDTO.getOrdersCount());
        customerEntity.setPhone(customerUpdateDTO.getPhone());
        customerEntity.setState(customerUpdateDTO.getState());
        customerEntity.setTags(customerUpdateDTO.getTags());
        customerEntity.setTaxExempt(customerUpdateDTO.getTaxExempt());
        customerEntity.setTaxExemptions(customerUpdateDTO.getTaxExemptions());
        customerEntity.setTotalSpend(customerUpdateDTO.getTotalSpend());
        customerEntity.setVerifiedEmail(customerUpdateDTO.getVerifiedEmail());
        customerEntity.setUpdatedAt(CommonUtils.convertLocalDateToDate(LocalDate.now()));

        return customerEntity;
    }

    private CustomerEntity createMapper(CustomerDTO customerDTO, CustomerEntity customerEntity) {

        List<AddressEntity> addressEntityList = getAddressList(customerDTO);

        MetafieldEntity metafieldEntity = new MetafieldEntity();
        metafieldEntity.setKys(customerDTO.getMetafield().getKey());
        metafieldEntity.setNameSpace(customerDTO.getMetafield().getNamespace());
        metafieldEntity.setValue(customerDTO.getMetafield().getValue());
        metafieldEntity.setValueType(customerDTO.getMetafield().getValueType());

        customerEntity.setAcceptsMarketing(customerDTO.getAcceptsMarketing());
        customerEntity.setAddressEntityList(addressEntityList);
        customerEntity.setCreated_ad(CommonUtils.convertLocalDateToDate(LocalDate.now()));
        customerEntity.setCurrency(customerDTO.getCurrency());
        customerEntity.setEmail(customerDTO.getEmail());
        customerEntity.setFirstName(customerDTO.getFirstName());
        customerEntity.setLastName(customerDTO.getLastName());
        customerEntity.setLastOrderId(Long.parseLong("12345"));
        customerEntity.setLastOrderName(customerDTO.getLastOrderName());
        customerEntity.setMarketingOptInLevel(customerDTO.getMarketingOptInLevel());
        customerEntity.setMetafield(metafieldEntity);
        customerEntity.setMultipassIdentifier(customerDTO.getMultipassIdentifier());
        customerEntity.setNote(customerDTO.getNote());
        customerEntity.setOrdersCount(customerDTO.getOrdersCount());
        customerEntity.setPhone(customerDTO.getPhone());
        customerEntity.setState(customerDTO.getState());
        customerEntity.setTags(customerDTO.getTags());
        customerEntity.setTaxExempt(customerDTO.getTaxExempt());
        customerEntity.setTaxExemptions(customerDTO.getTaxExemptions());
        customerEntity.setTotalSpend(customerDTO.getTotalSpend());
        customerEntity.setVerifiedEmail(customerDTO.getVerifiedEmail());

        return customerEntity;
    }

    private List<AddressEntity> getAddressList(CustomerDTO customerDTO) {
        List<AddressEntity> addressEntityList = customerDTO.getAddresses().stream()
                .filter(addressDTO -> Objects.nonNull(addressDTO))
                .map(addressDTO -> {
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
                    return addressEntity;
                }).collect(Collectors.toList());
        return addressEntityList;
    }

    private List<AddressEntity> getAddressUpdateList(CustomerUpdateDTO customerDTO) {
        List<AddressEntity> addressEntityList = customerDTO.getAddresses().stream()
                .filter(addressDTO -> Objects.nonNull(addressDTO))
                .map(addressDTO -> {
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
                    return addressEntity;
                }).collect(Collectors.toList());
        return addressEntityList;
    }

}

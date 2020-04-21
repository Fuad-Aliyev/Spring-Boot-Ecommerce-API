package com.sf_ecommerce.fncom.endpoints;

import com.sf_ecommerce.fncom.dto.response.errors.BaseResponseDTO;
import com.sf_ecommerce.fncom.dto.request.create.customers.AddressDTO;
import com.sf_ecommerce.fncom.dto.request.update.AddressUpdateDTO;
import com.sf_ecommerce.fncom.dto.response.AddressResponseDTO;
import com.sf_ecommerce.fncom.entities.customers.AddressEntity;
import com.sf_ecommerce.fncom.entities.customers.CustomerEntity;
import com.sf_ecommerce.fncom.factory.GeneralFactory;
import com.sf_ecommerce.fncom.services.AddressService;
import com.sf_ecommerce.fncom.services.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;

@Api
@Validated
@RestController
public class AddressController {

    @Autowired
    private Logger logger;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private ModelMapper modelMapper;

    @ApiOperation(value = "Retrieves addresses of spesific customers", tags = "Address Controller")
    @GetMapping("/customers/{id}/addresses")
    public BaseResponseDTO<AddressResponseDTO> getBulkAddresses(@PathVariable("id") Long id) {
        BaseResponseDTO<AddressResponseDTO> baseResponseDTO = GeneralFactory.createObject(BaseResponseDTO.class);
        List<AddressEntity> addressEntityList = customerService.getAddressesOfCustomer(id);
        baseResponseDTO.setData(convertAddressEntityToDto(addressEntityList));
        baseResponseDTO.setTimeStamp(LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond());
        return baseResponseDTO;
    }

    @ApiOperation(value = "Retrieves spesific address of spesific customers", tags = "Address Controller")
    @GetMapping("/customers/{customerId}/addresses/{addressId}")
    public BaseResponseDTO<AddressResponseDTO> getAddress(@PathVariable("customerId") Long customerId,
                                                                            @PathVariable("addressId") Long addressId) {
        BaseResponseDTO<AddressResponseDTO> baseResponseDTO = GeneralFactory.createObject(BaseResponseDTO.class);
        CustomerEntity customerEntity = customerService.getCustomerEntityById(customerId);
        AddressEntity addressEntity = addressService.getAddressOfCustomerForAddressId(customerEntity, addressId);
        baseResponseDTO.setData(convertAddressEntityToDto(Arrays.asList(addressEntity)));
        baseResponseDTO.setTimeStamp(LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond());
        return baseResponseDTO;
    }

    @ApiOperation(value = "Delete spesific address of spesific customers", tags = "Address Controller")
    @DeleteMapping("/customers/{customerId}/addresses/{addressId}")
    public BaseResponseDTO<AddressResponseDTO> deleteAddress(@PathVariable("customerId") Long customerId,
                                                             @PathVariable("addressId") Long addressId) {
        BaseResponseDTO<AddressResponseDTO> baseResponseDTO = GeneralFactory.createObject(BaseResponseDTO.class);
        addressService.deleteAddress(customerId, addressId);
        baseResponseDTO.setTimeStamp(LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond());
        return baseResponseDTO;
    }

    @ApiOperation(value = "Creates address for spesific customers", tags = "Address Controller")
    @PostMapping("/customers/{customerId}/addresses")
    public BaseResponseDTO<AddressResponseDTO> createAddress(@RequestBody @Valid AddressDTO addressDTO,
                                                             @PathVariable("customerId") Long customerId) {
        BaseResponseDTO<AddressResponseDTO> baseResponseDTO = GeneralFactory.createObject(BaseResponseDTO.class);
        AddressEntity addressEntity = addressService.createAddress(addressDTO, customerId);
        baseResponseDTO.setData(convertAddressEntityToDto(Arrays.asList(addressEntity)));
        baseResponseDTO.setTimeStamp(LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond());
        return baseResponseDTO;
    }

    @ApiOperation(value = "Updates address for spesific customers address", tags = "Address Controller")
    @PutMapping("/customers/{customerId}/addresses/{addressId}")
    public BaseResponseDTO<AddressResponseDTO> updateAddress(@RequestBody @Valid AddressUpdateDTO addressDTO,
                                                             @PathVariable("customerId") Long customerId,
                                                             @PathVariable("addressId") Long addressId) {
        BaseResponseDTO<AddressResponseDTO> baseResponseDTO = GeneralFactory.createObject(BaseResponseDTO.class);
        AddressEntity addressEntity = addressService.updateAddress(addressDTO, addressId, customerId);
        baseResponseDTO.setData(convertAddressEntityToDto(Arrays.asList(addressEntity)));
        baseResponseDTO.setTimeStamp(LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond());
        return baseResponseDTO;
    }

    @ApiOperation(value = "Sets address default for spesific customers", tags = "Address Controller")
    @PutMapping("/customers/{customerId}/addresses/{addressId}/default")
    public BaseResponseDTO<AddressResponseDTO> makeAddressDefault(@PathVariable("customerId") Long customerId,
                                                                  @PathVariable("addressId") Long addressId) {
        BaseResponseDTO<AddressResponseDTO> baseResponseDTO = GeneralFactory.createObject(BaseResponseDTO.class);
        AddressEntity addressEntity = addressService.updateAddress(addressId, customerId);
        baseResponseDTO.setData(convertAddressEntityToDto(Arrays.asList(addressEntity)));
        baseResponseDTO.setTimeStamp(LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond());
        return baseResponseDTO;
    }

    private List<AddressResponseDTO> convertAddressEntityToDto(List<AddressEntity> addressEntityList) {
        return Arrays.asList(
                modelMapper.map(addressEntityList, AddressResponseDTO[].class)
        );
    }
}

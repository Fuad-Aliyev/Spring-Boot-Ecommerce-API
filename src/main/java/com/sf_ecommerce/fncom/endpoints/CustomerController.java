package com.sf_ecommerce.fncom.endpoints;

import com.sf_ecommerce.fncom.dto.BaseResponseDTO;
import com.sf_ecommerce.fncom.dto.request.create.CustomerDTO;
import com.sf_ecommerce.fncom.dto.request.update.CustomerUpdateDTO;
import com.sf_ecommerce.fncom.dto.response.AddressResponseDTO;
import com.sf_ecommerce.fncom.dto.response.CustomerResponseDTO;
import com.sf_ecommerce.fncom.entities.AddressEntity;
import com.sf_ecommerce.fncom.entities.CustomerEntity;
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
import javax.websocket.server.PathParam;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@Api
@Validated
@RestController
//@RequestMapping(params = "/api/v1")
public class CustomerController {

    @Autowired
    private Logger logger;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private ModelMapper modelMapper;

    @ApiOperation(value = "Saves Customer Data", tags = "Customer Controller")
    @PostMapping("/customers")
    public BaseResponseDTO<CustomerResponseDTO> saveCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
        logger.info("Customer Create Request : " + customerDTO.toString());
        BaseResponseDTO<CustomerResponseDTO> baseResponseDTO = GeneralFactory.createObject(BaseResponseDTO.class);
        CustomerEntity customerEntity = customerService.saveCustomer(customerDTO);
        baseResponseDTO.setData(convertToDto(Arrays.asList(customerEntity)));
        baseResponseDTO.setTimeStamp(LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond());
        return baseResponseDTO;
    }

    @ApiOperation(value = "Updates Customer Data", tags = "Customer Controller")
    @PutMapping("/customers/{id}")
    public BaseResponseDTO<CustomerResponseDTO> updateCustomer(@RequestBody @Valid CustomerUpdateDTO customerUpdateDTO,
                                                               @PathVariable("id") Long id) {
        logger.info("Customer Update Request:" + customerUpdateDTO.toString());
        BaseResponseDTO<CustomerResponseDTO> baseResponseDTO = GeneralFactory.createObject(BaseResponseDTO.class);
        CustomerEntity customerEntity = customerService.updateCustomer(customerUpdateDTO, id);
        baseResponseDTO.setData(convertToDto(Arrays.asList(customerEntity)));
        baseResponseDTO.setTimeStamp(LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond());
        return baseResponseDTO;
    }

    @ApiOperation(value = "Gets Spesific Customer", tags = "Customer Controller")
    @GetMapping("/customers/{id:[\\d]+}")
    public BaseResponseDTO<CustomerResponseDTO> getCustomer(@PathVariable("id") Long id) {
        logger.info("Get customer with id:" + id);
        BaseResponseDTO<CustomerResponseDTO> baseResponseDTO = GeneralFactory.createObject(BaseResponseDTO.class);
        CustomerEntity customerEntity = customerService.getCustomerEntityById(id);
        baseResponseDTO.setData(convertToDto(Arrays.asList(customerEntity)));
        baseResponseDTO.setTimeStamp(LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond());
        return baseResponseDTO;
    }

    @ApiOperation(value = "Deletes Spesific Customer", tags = "Customer Controller")
    @DeleteMapping("/customers/{id:[\\d]+}")
    public BaseResponseDTO<CustomerResponseDTO> deleteCustomer(@PathVariable("id") Long id) {
        logger.info("Delete customer with id:" + id);
        BaseResponseDTO<CustomerResponseDTO> baseResponseDTO = GeneralFactory.createObject(BaseResponseDTO.class);
        customerService.deleteCustomerEntityById(id);
        baseResponseDTO.setTimeStamp(LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond());
        return baseResponseDTO;
    }

    @ApiOperation(value = "Retrieves a list of customers from spesific id", tags = "Customer Controller")
    @GetMapping("/customers")
    public BaseResponseDTO<CustomerResponseDTO> getaBulkCustomer(@RequestParam("sinceId") Long sinceId) {
        logger.info("id:" + sinceId);
        BaseResponseDTO<CustomerResponseDTO> baseResponseDTO = GeneralFactory.createObject(BaseResponseDTO.class);
        List<CustomerEntity> customerEntityList = customerService.getListOfCustomers(sinceId);
        baseResponseDTO.setData(convertToDto(customerEntityList));
        baseResponseDTO.setTimeStamp(LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond());
        return baseResponseDTO;
    }

    @ApiOperation(value = "Retrieves a list of customers for country", tags = "Customer Controller")
    @GetMapping("/customers-country")
    public BaseResponseDTO<CustomerResponseDTO> getCustomerByCountry(@RequestParam("country") String country,
                                                                     @RequestParam("limit") String limit,
                                                                     @RequestParam("size") String size) {
        BaseResponseDTO<CustomerResponseDTO> baseResponseDTO = GeneralFactory.createObject(BaseResponseDTO.class);
        List<CustomerEntity> customerEntityList = customerService.getListOfCustomers(country, Integer.valueOf(limit),
                Integer.valueOf(size));
        baseResponseDTO.setData(convertToDto(customerEntityList));
        baseResponseDTO.setTimeStamp(LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond());
        return baseResponseDTO;
    }

    @ApiOperation(value = "Retrieves count of customers count", tags = "Customer Controller")
    @GetMapping("/customers/count")
    public BaseResponseDTO<Map<String, Long>> getCustomerCount() {
        BaseResponseDTO<Map<String, Long>> baseResponseDTO = GeneralFactory.createObject(BaseResponseDTO.class);
        Long count = customerService.getCountOfCustomers();
        Map<String, Long> countMapping = new HashMap<>();
        countMapping.put("customer_count", count);
        baseResponseDTO.setData(countMapping);
        baseResponseDTO.setTimeStamp(LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond());
        return baseResponseDTO;
    }

    private List<CustomerResponseDTO> convertToDto(List<CustomerEntity> customerEntityList) {
        List<CustomerResponseDTO> customerResponseDTOList = customerEntityList.stream().map(
                customerEntity -> {
                    CustomerResponseDTO customerResponseDTO = modelMapper.map(customerEntity, CustomerResponseDTO.class);
                    List<AddressResponseDTO> addressResponseDTOList = Arrays.asList(
                            modelMapper.map(customerEntity.getAddressEntityList(), AddressResponseDTO[].class));
                    customerResponseDTO.setAddresses(addressResponseDTOList);
                    return customerResponseDTO;
                }
        ).collect(Collectors.toList());
        return customerResponseDTOList;
    }

}

package com.sf_ecommerce.fncom.endpoints;

import com.sf_ecommerce.fncom.dto.response.ProductResponseDTO;
import com.sf_ecommerce.fncom.dto.response.errors.BaseResponseDTO;
import com.sf_ecommerce.fncom.dto.request.create.products.ProductCreateDTO;
import com.sf_ecommerce.fncom.dto.response.CustomerResponseDTO;
import com.sf_ecommerce.fncom.entities.products.ProductEntity;
import com.sf_ecommerce.fncom.factory.GeneralFactory;
import com.sf_ecommerce.fncom.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.bouncycastle.asn1.ocsp.ResponseData;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Api
@Validated
@RestController
public class ProductController {

    @Autowired
    private Logger logger;

    @Autowired
    private ProductService productService;

    @Autowired
    private ModelMapper modelMapper;

    @ApiOperation(value = "Saves Product Data", tags = "Product Controller")
    @PostMapping("/products")
    public BaseResponseDTO<CustomerResponseDTO> saveProduct(@RequestBody @Valid ProductCreateDTO productCreateDTO,
                                                            UriComponentsBuilder uriComponentsBuilder,
                                                            HttpServletResponse response) {
        logger.info("Incoming product create request :: " + productCreateDTO.toString());
        ProductEntity productEntity = productService.createProduct(productCreateDTO);
        BaseResponseDTO baseResponseDTO = GeneralFactory.createObject(BaseResponseDTO.class);
        baseResponseDTO.setData(convertToDto(Arrays.asList(productEntity)));
        baseResponseDTO.setTimeStamp(LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond());
        response.setHeader("Location", uriComponentsBuilder.path("/products/{id}").buildAndExpand(productEntity.getId()).toUri().toString());
        return baseResponseDTO;
    }

    private List<ProductResponseDTO> convertToDto(List<ProductEntity> productEntityList) {
        List<ProductResponseDTO> productResponseDTOList = productEntityList.stream()
                .map(productEntity -> {
                    ProductResponseDTO productResponseDTO = modelMapper.map(productEntity, ProductResponseDTO.class);
                    return productResponseDTO;
                }).collect(Collectors.toList());
        return productResponseDTOList;
    }
}

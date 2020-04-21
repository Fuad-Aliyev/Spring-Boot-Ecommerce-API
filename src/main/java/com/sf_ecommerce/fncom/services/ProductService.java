package com.sf_ecommerce.fncom.services;

import com.sf_ecommerce.fncom.dto.request.create.products.ProductCreateDTO;
import com.sf_ecommerce.fncom.entities.products.ProductEntity;
import com.sf_ecommerce.fncom.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductRepository productRepository;

    public ProductEntity createProduct(ProductCreateDTO productCreateDTO) {
        ProductEntity productEntity = mapDtoEntity(productCreateDTO);
        String tags = productCreateDTO.getTags().stream()
                .map(tag -> {
                    tag = '#' + tag;
                    return tag;
                }).collect(Collectors.toList()).stream().reduce((s,p) -> s + ',' + p).get();
        productEntity.setTags(tags);
        productRepository.save(productEntity);
        return productEntity;
    }


    private ProductEntity mapDtoEntity(ProductCreateDTO productCreateDTO) {
        ProductEntity productEntity = new ProductEntity();
        modelMapper.map(productCreateDTO, productEntity);
        return productEntity;
    }
}

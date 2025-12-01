package com.example.delivery_service.service;

import com.example.delivery_service.dto.ProductDto;
import com.example.delivery_service.entity.Place;
import com.example.delivery_service.entity.Product;
import com.example.delivery_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> findAll() {
        return productRepository.findAll().stream().map(ProductService::toDto).collect(Collectors.toList());
    }
    public List<ProductDto> findByPlace(Place place) {
        return productRepository.findByPlace(place).stream().map(ProductService::toDto).collect(Collectors.toList());
    }
    public static ProductDto toDto(Product p) {
        return new ProductDto(p.getId(), p.getPlace()!=null?p.getPlace().getId():null, p.getName(), p.getPrice(), p.getWeightKg());
    }
}

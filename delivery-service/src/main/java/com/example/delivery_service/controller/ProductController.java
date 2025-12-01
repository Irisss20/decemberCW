package com.example.delivery_service.controller;

import com.example.delivery_service.dto.ProductDto;
import com.example.delivery_service.entity.Place;
import com.example.delivery_service.repository.PlaceRepository;
import com.example.delivery_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    private final PlaceRepository placeRepository;

    @Autowired
    public ProductController(ProductService productService, PlaceRepository placeRepository) {
        this.productService = productService;
        this.placeRepository = placeRepository;
    }

    @GetMapping
    public List<ProductDto> getProducts(@RequestParam(required = false) Long placeId) {
        if (placeId != null) {
            Place place = placeRepository.findById(placeId).orElse(null);
            if (place == null) return List.of();
            return productService.findByPlace(place);
        }
        return productService.findAll();
    }
}

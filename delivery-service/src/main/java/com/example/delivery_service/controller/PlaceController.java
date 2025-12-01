package com.example.delivery_service.controller;

import com.example.delivery_service.dto.PlaceDto;
import com.example.delivery_service.entity.Place;
import com.example.delivery_service.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/places")
public class PlaceController {
    private final PlaceService placeService;

    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping
    public List<PlaceDto> getAll(@RequestParam(required = false) String name,
                                 @RequestParam(required = false) Place.PlaceType type) {
        if (name != null && !name.isEmpty()) {
            return placeService.findByName(name);
        } else if (type != null) {
            return placeService.findByType(type);
        }
        return placeService.findAll();
    }
}

package com.example.delivery_service.service;

import com.example.delivery_service.dto.PlaceDto;
import com.example.delivery_service.entity.Place;
import com.example.delivery_service.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlaceService {
    private final PlaceRepository placeRepository;

    @Autowired
    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public List<PlaceDto> findAll() {
        return placeRepository.findAll().stream().map(PlaceService::toDto).collect(Collectors.toList());
    }
    public Optional<Place> findById(Long id) {
        return placeRepository.findById(id);
    }
    public List<PlaceDto> findByName(String name) {
        return placeRepository.findByNameContainingIgnoreCase(name).stream().map(PlaceService::toDto).collect(Collectors.toList());
    }
    public List<PlaceDto> findByType(Place.PlaceType type) {
        return placeRepository.findByType(type).stream().map(PlaceService::toDto).collect(Collectors.toList());
    }
    public static PlaceDto toDto(Place p) {
        return new PlaceDto(p.getId(), p.getName(), p.getType(), p.getCity(), p.getStreet(), p.getHouse());
    }
}

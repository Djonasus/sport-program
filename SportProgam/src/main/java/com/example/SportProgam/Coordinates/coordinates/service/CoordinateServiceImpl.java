package com.example.SportProgam.Coordinates.coordinates.service;

import com.example.SportProgam.Coordinates.coordinates.convert.CoordinateMapperManager;
import com.example.SportProgam.Coordinates.coordinates.dto.CoordinateRequestDto;
import com.example.SportProgam.Coordinates.coordinates.dto.CoordinateResponseDto;
import com.example.SportProgam.Coordinates.coordinates.repository.CoordinateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CoordinateServiceImpl implements CoordinateService {

    private final CoordinateRepository coordinateRepository;
    private final CoordinateMapperManager mapperManager;

    @Override
    public List<CoordinateResponseDto> finaAllCoordinate() {
        return mapperManager.toDto(
                coordinateRepository.findAll()
        );
    }

    @Override
    public void create(CoordinateRequestDto dto) {
        coordinateRepository.save(
                mapperManager.toModel(dto)
        );
    }
}

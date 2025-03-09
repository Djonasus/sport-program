package com.example.SportProgam.Coordinates.service;

import com.example.SportProgam.Coordinates.convert.CoordinateMapperManager;
import com.example.SportProgam.Coordinates.dto.CoordinateRequestDto;
import com.example.SportProgam.Coordinates.dto.CoordinateResponseDto;
import com.example.SportProgam.Coordinates.model.CoordinateModel;
import com.example.SportProgam.Coordinates.repository.CoordinateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CoordinateServiceImpl implements CoordinateService {

    private final CoordinateRepository coordinateRepository;
    private final CoordinateMapperManager mapperManager;

    @Override
    public List<CoordinateResponseDto> findAllCoordinates() {

        return mapperManager.toDto(
                coordinateRepository.findAll()
        );
    }

    @Override
    public void create(CoordinateRequestDto dto) {
        CoordinateModel model = mapperManager.toModel(dto);
        model.setCoordinateid(coordinateRepository.count()+1);
        coordinateRepository.save(model);
    }
}

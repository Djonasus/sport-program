package com.example.SportProgam.Coordinates.coordinates.convert;

import com.example.SportProgam.Coordinates.coordinates.dto.CoordinateRequestDto;
import com.example.SportProgam.Coordinates.coordinates.dto.CoordinateResponseDto;
import com.example.SportProgam.Coordinates.coordinates.model.Coordinate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;



@Component
@RequiredArgsConstructor
public class CoordinateMapperManagerImpl implements CoordinateMapperManager {

    private final CoordinateMapper coordinateMapper;
    private final CoordinateListMapper coordinateListMapper;

    @Override
    public Coordinate toModel(CoordinateRequestDto dto) {
        return coordinateMapper.toModel(dto);
    }

    @Override
    public CoordinateResponseDto toDto(Coordinate model) {
        return coordinateMapper.toDto(model);
    }

    @Override
    public List<CoordinateResponseDto> toDto(List<Coordinate> model) {
        return coordinateListMapper.toDto(model);
    }
}

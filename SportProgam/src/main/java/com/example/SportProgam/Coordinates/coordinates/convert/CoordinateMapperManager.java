package com.example.SportProgam.Coordinates.coordinates.convert;

import com.example.SportProgam.Coordinates.coordinates.dto.CoordinateRequestDto;
import com.example.SportProgam.Coordinates.coordinates.dto.CoordinateResponseDto;
import com.example.SportProgam.Coordinates.coordinates.model.Coordinate;

import java.util.List;

public interface CoordinateMapperManager {
    Coordinate toModel(CoordinateRequestDto dto);
    CoordinateResponseDto toDto(Coordinate model);
    List<CoordinateResponseDto> toDto(List<Coordinate> model);
}

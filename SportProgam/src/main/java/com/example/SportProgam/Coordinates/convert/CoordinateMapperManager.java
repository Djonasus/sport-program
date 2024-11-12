package com.example.SportProgam.Coordinates.convert;

import com.example.SportProgam.Coordinates.dto.CoordinateRequestDto;
import com.example.SportProgam.Coordinates.dto.CoordinateResponseDto;
import com.example.SportProgam.Coordinates.model.Coordinate;

import java.util.List;

public interface CoordinateMapperManager {
    Coordinate toModel(CoordinateRequestDto dto);
    CoordinateResponseDto toDto(Coordinate model);
    List<CoordinateResponseDto> toDto(List<Coordinate> model);
}

package com.example.SportProgam.Coordinates.convert;

import com.example.SportProgam.Coordinates.dto.CoordinateRequestDto;
import com.example.SportProgam.Coordinates.dto.CoordinateResponseDto;
import com.example.SportProgam.Coordinates.model.CoordinateModel;

import java.util.List;

public interface CoordinateMapperManager {
    CoordinateModel toModel(CoordinateRequestDto dto);
    CoordinateResponseDto toDto(CoordinateModel model);
    List<CoordinateResponseDto> toDto(List<CoordinateModel> model);
}

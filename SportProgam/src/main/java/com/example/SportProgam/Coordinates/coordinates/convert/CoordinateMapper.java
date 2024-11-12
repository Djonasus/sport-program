package com.example.SportProgam.Coordinates.coordinates.convert;


import com.example.SportProgam.Coordinates.coordinates.dto.CoordinateRequestDto;
import com.example.SportProgam.Coordinates.coordinates.dto.CoordinateResponseDto;
import com.example.SportProgam.Coordinates.coordinates.model.Coordinate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoordinateMapper {

    Coordinate toModel(CoordinateRequestDto dto);
    CoordinateResponseDto toDto(Coordinate model);
}

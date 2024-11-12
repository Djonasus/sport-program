package com.example.SportProgam.Coordinates.convert;


import com.example.SportProgam.Coordinates.dto.CoordinateRequestDto;
import com.example.SportProgam.Coordinates.dto.CoordinateResponseDto;
import com.example.SportProgam.Coordinates.model.Coordinate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoordinateMapper {

    Coordinate toModel(CoordinateRequestDto dto);
    CoordinateResponseDto toDto(Coordinate model);
}

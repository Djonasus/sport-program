package com.example.SportProgam.Coordinates.convert;


import com.example.SportProgam.Coordinates.dto.CoordinateRequestDto;
import com.example.SportProgam.Coordinates.dto.CoordinateResponseDto;
import com.example.SportProgam.Coordinates.model.CoordinateModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoordinateMapper {

    CoordinateModel toModel(CoordinateRequestDto dto);
    CoordinateResponseDto toDto(CoordinateModel model);
}

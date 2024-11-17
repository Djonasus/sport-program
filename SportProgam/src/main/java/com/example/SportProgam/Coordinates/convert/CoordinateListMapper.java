package com.example.SportProgam.Coordinates.convert;


import com.example.SportProgam.Coordinates.dto.CoordinateResponseDto;
import com.example.SportProgam.Coordinates.model.Coordinate;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = CoordinateMapper.class)
public interface CoordinateListMapper {

    List<CoordinateResponseDto> toDto(List<Coordinate> model);
}
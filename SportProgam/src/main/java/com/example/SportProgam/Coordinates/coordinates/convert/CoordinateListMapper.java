package com.example.SportProgam.Coordinates.coordinates.convert;


import com.example.SportProgam.Coordinates.coordinates.dto.CoordinateResponseDto;
import com.example.SportProgam.Coordinates.coordinates.model.Coordinate;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = CoordinateMapper.class)
public interface CoordinateListMapper {

    List<CoordinateResponseDto> toDto(List<Coordinate> model);
}

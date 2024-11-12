package com.example.SportProgam.Coordinates.mapper;

import com.example.SportProgam.Coordinates.dto.TypeResponseDto;
import com.example.SportProgam.Coordinates.model.Type;
import com.example.SportProgam.Coordinates.service.TypeRequestDto;

import java.util.List;

public interface TypeMapperManager {

    Type toModel(TypeRequestDto dto);
    TypeResponseDto toDto(Type model);
    List<TypeResponseDto> toDto(List<Type> model);

}

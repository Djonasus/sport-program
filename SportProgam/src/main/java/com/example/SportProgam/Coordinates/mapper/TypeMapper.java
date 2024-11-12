package com.example.SportProgam.Coordinates.mapper;


import com.example.SportProgam.Coordinates.dto.TypeResponseDto;
import com.example.SportProgam.Coordinates.model.Type;
import com.example.SportProgam.Coordinates.service.TypeRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TypeMapper {
    Type toModel(TypeRequestDto dto);
    TypeResponseDto toDto(Type model);
}

package com.example.SportProgam.Coordinates.mapper;

import com.example.SportProgam.Coordinates.dto.TypeResponseDto;
import com.example.SportProgam.Coordinates.model.Type;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring", uses = TypeMapper.class)
public interface TypeListMapper {

    List<TypeResponseDto> toDto(List<Type> model);
}

package com.example.SportProgam.Coordinates.mapper;

import com.example.SportProgam.Coordinates.dto.TypeResponseDto;
import com.example.SportProgam.Coordinates.model.Type;
import com.example.SportProgam.Coordinates.service.TypeRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class TypeMapperManagerImpl implements TypeMapperManager {

    private final TypeMapper typeMapper;
    private final TypeListMapper typeListMapper;

    @Override
    public Type toModel(TypeRequestDto dto) {
        return typeMapper.toModel(dto);
    }

    @Override
    public TypeResponseDto toDto(Type model) {
        return typeMapper.toDto(model);
    }

    @Override
    public List<TypeResponseDto> toDto(List<Type> model) {
        return typeListMapper.toDto(model);
    }
}

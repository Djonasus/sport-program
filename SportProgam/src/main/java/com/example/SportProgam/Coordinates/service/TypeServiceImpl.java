package com.example.SportProgam.Coordinates.service;

import com.example.SportProgam.Coordinates.dto.TypeResponseDto;
import com.example.SportProgam.Coordinates.mapper.TypeMapperManager;
import com.example.SportProgam.Coordinates.repostiory.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TypeServiceImpl implements TypeService {

    private final TypeRepository typeRepository;
    private final TypeMapperManager mapperManager;


    @Override
    public List<TypeResponseDto> findAllTypes() {
        return mapperManager.toDto(typeRepository.findAll());
    }

    @Override
    public void createType(TypeRequestDto dto) {

    }
}

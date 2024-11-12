package com.example.SportProgam.Coordinates.service;

import com.example.SportProgam.Coordinates.dto.TypeResponseDto;
import com.example.SportProgam.Coordinates.repostiory.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TypeServiceImpl implements TypeService {

    private final TypeRepository typeRepository;


    @Override
    public List<TypeResponseDto> findAllTypes() {
        return typeRepository.findAll();
    }

    @Override
    public void createType(TypeRequestDto dto) {

    }
}

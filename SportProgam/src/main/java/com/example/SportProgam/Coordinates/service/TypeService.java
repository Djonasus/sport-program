package com.example.SportProgam.Coordinates.service;

import com.example.SportProgam.Coordinates.dto.TypeResponseDto;

import java.util.List;

public interface TypeService {

     List<TypeResponseDto> findAllTypes();

     void createType(TypeRequestDto dto);
}

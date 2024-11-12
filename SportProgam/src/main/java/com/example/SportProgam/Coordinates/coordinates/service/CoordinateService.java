package com.example.SportProgam.Coordinates.coordinates.service;

import com.example.SportProgam.Coordinates.coordinates.dto.CoordinateRequestDto;
import com.example.SportProgam.Coordinates.coordinates.dto.CoordinateResponseDto;

import java.util.List;

public interface CoordinateService {

    List<CoordinateResponseDto> finaAllCoordinate();
    void create(CoordinateRequestDto dto);
}

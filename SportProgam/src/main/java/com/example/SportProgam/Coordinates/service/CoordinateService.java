package com.example.SportProgam.Coordinates.service;

import com.example.SportProgam.Coordinates.dto.CoordinateRequestDto;
import com.example.SportProgam.Coordinates.dto.CoordinateResponseDto;

import java.util.List;

public interface CoordinateService {

    List<CoordinateResponseDto> findAllCoordinates();
    void create(CoordinateRequestDto dto);
}

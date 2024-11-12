package com.example.SportProgam.Coordinates.dto;

import java.util.List;

public record CoordinateAllResponseDto(
        List<CoordinateResponseDto> children
) {

}

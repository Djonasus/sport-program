package com.example.SportProgam.Coordinates.dto;

public record CoordinateResponseDto(
        Double x,
        Double y,
        String description,
        String type
) {
}

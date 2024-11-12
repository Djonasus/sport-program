package com.example.SportProgam.Coordinates.coordinates.dto;

public record CoordinateResponseDto(
        Double x,
        Double y,
        String description,
        String type
) {
}

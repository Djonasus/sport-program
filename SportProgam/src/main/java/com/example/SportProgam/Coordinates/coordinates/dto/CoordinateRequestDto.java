package com.example.SportProgam.Coordinates.coordinates.dto;

public record CoordinateRequestDto(
        Double x,
        Double y,
        String description,
        String type
) {
}

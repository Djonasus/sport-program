package com.example.SportProgam.Coordinates.dto;

public record CoordinateRequestDto(
        Double x,
        Double y,
        String name,
        String description
) {
}

package com.example.SportProgam.Coordinates.dto;

import java.util.List;

public record CoordinateResponseDto(
        Long coordinateId,
        List<Double> coords,
        String name,
        String description,
        List<String> field_types,
        List<EventLittleInfo> events
) {
}

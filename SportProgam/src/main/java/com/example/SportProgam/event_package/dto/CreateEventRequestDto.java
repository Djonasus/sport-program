package com.example.SportProgam.event_package.dto;
public record CreateEventRequestDto(
        String title,
        String description,
        String sport,
        String date,
        String time,
        int maxCount,
        long coordId,
        long userId
) {
}

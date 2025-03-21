package com.example.SportProgam.admin_package.dto;
public record RequestEventResponseDto(
        long event_request_id,
        String title,
        String description,
        String date,
        String time,
        String type,
        String name,
        int maxCountInOneTeam
) {
}

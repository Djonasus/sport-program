package com.example.SportProgam.event_package.dto;

public record RequestToEventDto(
        Long eventId,
        Integer team,
        Long userId
) {

}

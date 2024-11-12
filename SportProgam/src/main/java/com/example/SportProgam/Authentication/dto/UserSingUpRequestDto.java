package com.example.SportProgam.Authentication.dto;

public record UserSingUpRequestDto(
        String email,
        String login,
        String password
) {
}

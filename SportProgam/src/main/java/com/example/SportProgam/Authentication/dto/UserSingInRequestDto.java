package com.example.SportProgam.Authentication.dto;

public record UserSingInRequestDto(
        String login,
        String password
) {
}

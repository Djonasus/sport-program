package com.example.SportProgam.Authentication.dto;

public record UserDetailInformationResponseDto(
        Long id,
        String login,
        String email,
        String password,
        String role
) {
}

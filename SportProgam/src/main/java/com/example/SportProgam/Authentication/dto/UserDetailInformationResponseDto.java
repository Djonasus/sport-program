package com.example.SportProgam.Authentication.dto;

public record UserDetailInformationResponseDto(
        Long id,
        String email,
        String role
) {
}

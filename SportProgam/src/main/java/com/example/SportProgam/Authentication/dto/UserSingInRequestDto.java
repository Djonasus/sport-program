package com.example.SportProgam.Authentication.dto;

public record UserSingInRequestDto(
        String email,
        String password
) {
}

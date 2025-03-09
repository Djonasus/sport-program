package com.example.SportProgam.Authentication.dto;


public record UserSingUpRequestDto(
        String email,
        String password,
        String name,
        String lastName
) {
}

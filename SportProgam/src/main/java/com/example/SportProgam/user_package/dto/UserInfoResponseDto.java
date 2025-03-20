package com.example.SportProgam.user_package.dto;

public record UserInfoResponseDto(
        Long user_id,
        String email,
        String password,
        String name,
        String last_name,
        String role,
        String image_path
) {
}

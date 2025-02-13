package com.example.SportProgam.event_package.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long user_id;
    private String name;
    private String lastname;
    private String imageApi;

}

package com.example.SportProgam.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChildrenResponseDto {
    private Long id;
    private String title;
    private String date;
    private String preview;
}

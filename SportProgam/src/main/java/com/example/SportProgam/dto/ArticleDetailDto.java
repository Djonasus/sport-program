package com.example.SportProgam.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDetailDto {
    private Long id;
    private String title;
    private String date;
    private String body;
    private String preview;
    private String author;
}

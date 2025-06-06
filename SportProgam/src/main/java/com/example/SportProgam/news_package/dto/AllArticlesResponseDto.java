package com.example.SportProgam.news_package.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AllArticlesResponseDto {
    private List<ChildrenResponseDto> children;
}

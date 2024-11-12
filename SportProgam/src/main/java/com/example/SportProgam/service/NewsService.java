package com.example.SportProgam.service;

import com.example.SportProgam.dto.AllArticlesResponseDto;
import com.example.SportProgam.dto.ArticleDetailDto;

public interface NewsService {

    AllArticlesResponseDto getAllWithLimit(Long limit);

    ArticleDetailDto getById(Long id);
}

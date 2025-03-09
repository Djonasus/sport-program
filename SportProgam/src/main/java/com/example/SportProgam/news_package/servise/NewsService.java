package com.example.SportProgam.news_package.servise;

import com.example.SportProgam.news_package.dto.AllArticlesResponseDto;
import com.example.SportProgam.news_package.dto.ArticleDetailDto;

public interface NewsService {

    AllArticlesResponseDto getAllWithLimit(Long limit, Boolean shuffle);

    ArticleDetailDto getById(Long id);
}

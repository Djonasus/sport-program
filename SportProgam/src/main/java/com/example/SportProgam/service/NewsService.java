package com.example.SportProgam.service;

import com.example.SportProgam.dto.AllArticlesResponseDto;

public interface NewsService {

    AllArticlesResponseDto getAllWithLimit(Long limit);
}

package com.example.SportProgam.news_package.servise;

import com.example.SportProgam.news_package.dto.AllArticlesResponseDto;
import com.example.SportProgam.news_package.dto.ArticleDetailDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface NewsService {

    AllArticlesResponseDto getAllWithLimit(Long limit, Boolean shuffle);

    ArticleDetailDto getById(Long id);

    void createNews(MultipartFile multipartFile, String title, String body, String author) throws IOException;
}

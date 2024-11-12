package com.example.SportProgam.controller;

import com.example.SportProgam.dto.AllArticlesResponseDto;
import com.example.SportProgam.dto.ArticleDetailDto;
import com.example.SportProgam.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/article")
public class NewsController {
    private final NewsService newsService;

    @GetMapping("/all")
    public ResponseEntity<AllArticlesResponseDto> getAllWithLimit(@RequestParam Long  limit) {
        return ResponseEntity.ok(newsService.getAllWithLimit(limit));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDetailDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(newsService.getById(id));
    }

}
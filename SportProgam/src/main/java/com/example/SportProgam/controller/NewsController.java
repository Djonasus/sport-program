package com.example.SportProgam.controller;

import com.example.SportProgam.dto.AllArticlesResponseDto;
import com.example.SportProgam.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/article")
public class NewsController {
    private final NewsService newsService;

    @GetMapping("/all")
    public ResponseEntity<AllArticlesResponseDto> getAllWithLimit(@RequestParam Long  limit) {
        return ResponseEntity.ok(newsService.getAllWithLimit(limit));
    }

}

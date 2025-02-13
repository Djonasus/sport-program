package com.example.SportProgam.news_package.controller;

import com.example.SportProgam.news_package.dto.AllArticlesResponseDto;
import com.example.SportProgam.news_package.dto.ArticleDetailDto;
import com.example.SportProgam.news_package.servise.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/article")
//@CrossOrigin(origins = "http://localhost:3000")
public class NewsController {
    private final NewsService newsService;

    @CrossOrigin("*")
    @GetMapping("/all")
    public ResponseEntity<AllArticlesResponseDto> getAllWithLimit(@RequestParam(required = false) Long  limit,
                                                                  @RequestParam(required = true) Boolean shuffle) {
        return ResponseEntity.ok(newsService.getAllWithLimit(limit, shuffle));
    }

    @CrossOrigin("*")
    @GetMapping("/{id}")
    public ResponseEntity<ArticleDetailDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(newsService.getById(id));
    }

}

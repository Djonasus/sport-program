package com.example.SportProgam.news_package.controller;

import com.example.SportProgam.news_package.dto.AllArticlesResponseDto;
import com.example.SportProgam.news_package.dto.ArticleDetailDto;
import com.example.SportProgam.news_package.servise.NewsService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/article")
//@CrossOrigin(origins = "http://localhost:3000")
public class NewsController {
    private static final Logger log = LoggerFactory.getLogger(NewsController.class);
    private final NewsService newsService;

    @CrossOrigin("*")
//    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @GetMapping("/all")
    public ResponseEntity<AllArticlesResponseDto> getAllWithLimit(@RequestParam(required = false) Long  limit,
                                                                  @RequestParam(required = true) Boolean shuffle) {
//        log.info("news");
        return ResponseEntity.ok(newsService.getAllWithLimit(limit, shuffle));
    }

    @CrossOrigin("*")
    @GetMapping("/{id}")
    public ResponseEntity<ArticleDetailDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(newsService.getById(id));
    }

}

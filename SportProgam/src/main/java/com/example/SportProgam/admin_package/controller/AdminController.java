package com.example.SportProgam.admin_package.controller;

import com.example.SportProgam.event_package.service.EventRequestService;
import com.example.SportProgam.news_package.servise.NewsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final EventRequestService eventRequestService;
    private final NewsService newsService;

    @CrossOrigin("*")
    @GetMapping("/wait-event")
    public ResponseEntity<?> getRequestEvents() {
        return ResponseEntity.ok(eventRequestService.getAllRequestEvents());
    }

    @CrossOrigin("*")
    @PutMapping("/wait-event/{eventId}")
    public ResponseEntity<?> getAccessForEventRequest(@PathVariable Long eventId,
                                                     @RequestParam boolean trueOrFalse) {
        log.info("eventid: {}, trueOfFalse: {}", eventId, trueOrFalse);
        eventRequestService.getAccessToEvent(eventId, trueOrFalse);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin("*")
    @PostMapping(value = "/news", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createNews(@RequestPart MultipartFile multipartFile,
                                        @RequestParam("title") String title,
                                        @RequestParam("body") String body,
                                        @RequestParam("author") String author) {
        try {
            newsService.createNews(multipartFile, title, body, author);
            return new ResponseEntity<>(HttpStatusCode.valueOf(201));
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(441));
        }

    }
}

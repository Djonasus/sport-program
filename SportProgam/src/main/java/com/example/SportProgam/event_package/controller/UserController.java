package com.example.SportProgam.event_package.controller;

import com.example.SportProgam.event_package.dto.EventForUserResponseDto;
import com.example.SportProgam.event_package.service.EventService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final EventService service;

    @CrossOrigin("*")
    @GetMapping("/profile")
    public String userTest() {
        return "successfull";
    }
    @CrossOrigin("*")
//    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", allowedHeaders = "true")
    @PostMapping("/event/{eventId}")
    public EventForUserResponseDto getEventInfo(@PathVariable long eventId) {
        log.info("4353event");
//        return ResponseEntity.ok(service.getEventInfo(eventId));
        return service.getEventInfo(eventId);
    }



}

package com.example.SportProgam.event_package.controller;

import com.example.SportProgam.event_package.dto.EventForUserResponseDto;
import com.example.SportProgam.event_package.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final EventService service;
    @CrossOrigin("*")
    @GetMapping("/profile")
    public String userTest() {
        return "successfull";
    }
    @CrossOrigin("*")
    @GetMapping("/event/{eventId}")
    public ResponseEntity<EventForUserResponseDto> getEventInfo(@PathVariable long eventId) {
        return ResponseEntity.ok(service.getEventInfo(eventId));
    }



}

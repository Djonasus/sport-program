package com.example.SportProgam.event_package.controller;

import com.example.SportProgam.event_package.dto.EventForUserResponseDto;
import com.example.SportProgam.event_package.dto.RequestToEventDto;
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
    @GetMapping("/event/{eventId}")
    public EventForUserResponseDto getEventInfo(@PathVariable long eventId) {
        return service.getEventInfo(eventId);
    }

    @CrossOrigin("*")
    @PostMapping("/request/event")
    public ResponseEntity<Void> requestToEvent(@RequestBody RequestToEventDto dto) {
        service.requestToEvent(dto);
        return ResponseEntity.ok().build();
    }

}

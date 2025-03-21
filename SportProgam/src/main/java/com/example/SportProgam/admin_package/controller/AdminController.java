package com.example.SportProgam.admin_package.controller;

import com.example.SportProgam.event_package.service.EventRequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final EventRequestService eventRequestService;

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
        return ResponseEntity.ok().build();
    }
}

package com.example.SportProgam.event_package.controller;

import com.example.SportProgam.event_package.dto.CreateEventRequestDto;
import com.example.SportProgam.event_package.dto.EventForUserResponseDto;
import com.example.SportProgam.event_package.dto.RequestToEventDto;
import com.example.SportProgam.event_package.service.EventService;
import io.jsonwebtoken.Jwt;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class EventController {

    private static final Logger log = LoggerFactory.getLogger(EventController.class);
    private final EventService service;

    @CrossOrigin("*")
    @GetMapping("/profile")
    public String userTest() {
        return "successfull";
    }

    /**
     * end point for показать инфу об одном событии вместе с участниками
     * @param eventId - id мероприятия
     * @return инфу
     */
    @CrossOrigin("*")
    @GetMapping("/event/{eventId}")
    public ResponseEntity<EventForUserResponseDto> getEventInfo(@PathVariable long eventId) {
        try {
            return ResponseEntity.ok(service.getEventInfo(eventId));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(441));
        }
    }

    // 200 suc
    @CrossOrigin("*")
    @PostMapping("/event")
    public ResponseEntity<Void> createEvent(@RequestBody CreateEventRequestDto requestDto,
                                            @AuthenticationPrincipal UserDetails userDetails) {
        try {
            String username = userDetails.getUsername();
            service.createEventByDto(requestDto, username);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(441));
        }
    }

    /**
     * end point for запроса на участие в эвенте завершен
     * @param dto - Long eventId, Integer team, Long userId
     * @return 200/441
     */
    @CrossOrigin("*")
    @PostMapping("/request/event")
    public ResponseEntity<Void> requestToEvent(@RequestBody RequestToEventDto dto) {
        try {
            service.requestToEvent(dto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(441));
        }
    }

}

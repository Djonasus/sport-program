package com.example.SportProgam.user_package.controller;

import com.example.SportProgam.Authentication.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserConroller {

    private final UserService userService;

    @CrossOrigin("*")
    @GetMapping("/info/{userId}")
    public ResponseEntity<?> getInfoById(@PathVariable long userId) {
        try {
            return ResponseEntity.ok(userService.findInfoByUserId(userId));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(441));
        }
    }

    @CrossOrigin("*")
    @PostMapping(value = "/image/{userId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createUserImage(@PathVariable long userId,
                                             @RequestPart MultipartFile multipartFile) {
        try {
            userService.savePhoto(userId, multipartFile);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.warn("error in /api/user/image/{userId}");
        }
        return new ResponseEntity<>(HttpStatusCode.valueOf(441));

    }

    @CrossOrigin("*")
    @GetMapping("event?user_id={:id} ")
    public ResponseEntity<?> getUserEvents(@RequestParam(name = "user_id") Long userid) {
        return ResponseEntity.ok(userService.findUserEvents(userid));
    }

}

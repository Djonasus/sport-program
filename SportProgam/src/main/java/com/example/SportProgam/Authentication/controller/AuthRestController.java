package com.example.SportProgam.Authentication.controller;


import com.example.SportProgam.Authentication.dto.TokenAndUserIdDto;
import com.example.SportProgam.Authentication.dto.UserDetailInformationResponseDto;
import com.example.SportProgam.Authentication.dto.UserSingInRequestDto;
import com.example.SportProgam.Authentication.dto.UserSingUpRequestDto;
import com.example.SportProgam.Authentication.model.UserModel;
import com.example.SportProgam.Authentication.security.JwtTokenProvider;
import com.example.SportProgam.Authentication.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authentication")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://185.121.14.6:3000")
public class AuthRestController {

    private final UserService userService;

    @PostMapping("/SingUp")
    @CrossOrigin("*")
    public ResponseEntity<?> singUp(@RequestBody UserSingUpRequestDto singUpGuestUserDto) {
        try {
            return ResponseEntity.ok(userService.singUp(singUpGuestUserDto));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(441));
        }
    }

    @PostMapping("/SingIn")
    @CrossOrigin(origins = "http://185.121.14.6:3000")
//    @CrossOrigin("*")
    public ResponseEntity<?> singIn(@RequestBody UserSingInRequestDto singInDto) {
        try {
            return ResponseEntity.ok(userService.loginIn(singInDto));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}


package com.example.SportProgam.controller;


import com.example.SportProgam.Authentication.dto.UserSingIRequestDto;
import com.example.SportProgam.Authentication.model.User;
import com.example.SportProgam.Authentication.security.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Authentication")
@RequiredArgsConstructor
@Slf4j
public class AuthRestController {

    private final AuthenticationService authenticationService;

    @PostMapping("/SignUp")
    public ResponseEntity<?> singUp(@RequestBody User singUpGuestUserDto,
                                    BindingResult bindingResult) throws BindException {
        log.info("данные для регестрации: {}", singUpGuestUserDto);
        if (bindingResult.hasErrors()) {
            if (bindingResult instanceof BindException exception) {
                throw exception;
            } else throw new BindException(bindingResult);
        } else {

            //authenticationService.signUp(singUpGuestUserDto);
            log.info("аккаунт зарегестрирован");
            return ResponseEntity.noContent().build();
        }
    }


    @PostMapping("/SignIn")
    public ResponseEntity<?> signIn(@RequestBody UserSingIRequestDto singInDot) {
        log.info("данные для аунтефикации: {}", singInDot);
        authenticationService.signIn(singInDot);
        log.info("аунитфикация прошла успено");
        return ResponseEntity.noContent().build();
    }
}


package com.example.SportProgam.Authentication.controller;


import com.example.SportProgam.Authentication.dto.UserDetailInformationResponseDto;
import com.example.SportProgam.Authentication.dto.UserSingInRequestDto;
import com.example.SportProgam.Authentication.dto.UserSingUpRequestDto;
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

    @PostMapping("/SingUp")
    public ResponseEntity<?> singUp(@RequestBody UserSingUpRequestDto singUpGuestUserDto,
                                    BindingResult bindingResult) throws BindException {
        log.info("данные для регестрации: {}", singUpGuestUserDto);
        if (bindingResult.hasErrors()) {
            if (bindingResult instanceof BindException exception) {
                throw exception;
            } else throw new BindException(bindingResult);
        } else {

            authenticationService.signUp(singUpGuestUserDto);
            log.info("аккаунт зарегестрирован");
            return ResponseEntity.noContent().build();
        }
    }


    @PostMapping("/SingIn")
    public ResponseEntity<?> singIn(@RequestBody UserSingInRequestDto singInDot) {
        log.info("данные для аунтефикации: {}", singInDot);
        UserDetailInformationResponseDto userDetailInformationResponseDto =  authenticationService.signIn(singInDot);
        log.info("аунитфикация прошла успено");
        return ResponseEntity.ok().body(
                userDetailInformationResponseDto
        );
    }
}


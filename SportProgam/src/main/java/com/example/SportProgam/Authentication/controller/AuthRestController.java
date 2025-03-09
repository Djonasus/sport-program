package com.example.SportProgam.Authentication.controller;


import com.example.SportProgam.Authentication.dto.TokenAndUserIdDto;
import com.example.SportProgam.Authentication.dto.UserDetailInformationResponseDto;
import com.example.SportProgam.Authentication.dto.UserSingInRequestDto;
import com.example.SportProgam.Authentication.dto.UserSingUpRequestDto;
import com.example.SportProgam.Authentication.security.JwtTokenProvider;
import com.example.SportProgam.Authentication.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authentication")
@RequiredArgsConstructor
@Slf4j
public class AuthRestController {

    //    private final AuthenticationService authenticationService;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/SingUp")
    @CrossOrigin("*")
//    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public ResponseEntity<?> singUp(@RequestBody UserSingUpRequestDto singUpGuestUserDto){
        log.info("данные для регестрации: {}", singUpGuestUserDto);
//        if (bindingResult.hasErrors()) {
//            if (bindingResult instanceof BindException exception) {
//                throw exception;
//            } else throw new BindException(bindingResult);
//        } else {
        long userId = userService.save(singUpGuestUserDto).getUser_id();
//        log.info("аккаунт зарегестрирован");
        Authentication authentication1 = new UsernamePasswordAuthenticationToken(singUpGuestUserDto.email(), singUpGuestUserDto.password());
        Authentication authentication = authenticationManager.authenticate(
                authentication1
        );
//        log.info("authentication: {}", authentication);

        // Генерация JWT токена
        String token = jwtTokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new TokenAndUserIdDto(token, userId, "User"));
//            return ResponseEntity.noContent().build();
//        }
    }

    @PostMapping("/SingIn")
    @CrossOrigin("*")
//    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public ResponseEntity<?> singIn(@RequestBody UserSingInRequestDto singInDot) {
        //не хватает проверки на присутствие пользователя при входе, проверить данную способность в крестики нолики, возмножно можно войти любым

        Authentication authentication1 = new UsernamePasswordAuthenticationToken(singInDot.email(), singInDot.password());
        Authentication authentication = authenticationManager.authenticate(
                authentication1
        );
//        log.info("authentication: {}", authentication);

        // Генерация JWT токена
        String token = jwtTokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new TokenAndUserIdDto(token, 1L, "User"));
//        return token;
    }
}


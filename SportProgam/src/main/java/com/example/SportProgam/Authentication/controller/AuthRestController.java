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
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
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
    public ResponseEntity<?> singUp(@RequestBody UserSingUpRequestDto singUpGuestUserDto){
        try {
            log.info("данные для регестрации: {}", singUpGuestUserDto);
            long userId = userService.save(singUpGuestUserDto).getUser_id();
            Authentication authentication1 = new UsernamePasswordAuthenticationToken(singUpGuestUserDto.email(), singUpGuestUserDto.password());
            Authentication authentication = authenticationManager.authenticate(
                    authentication1
            );

            String token = jwtTokenProvider.generateToken(authentication);
            return ResponseEntity.ok(new TokenAndUserIdDto(token, userId, "User"));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(441));
        }
    }

    @PostMapping("/SingIn")
    @CrossOrigin("*")
//    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public ResponseEntity<?> singIn(@RequestBody UserSingInRequestDto singInDto) {
        //не хватает проверки на присутствие пользователя при входе, проверить данную способность в крестики нолики, возмножно можно войти любым
        log.info("data for login is {}", singInDto);
        Long userId = null;
        UserModel userModel;
        try {
            userModel = userService.findUserByEmail(singInDto.email());
            userId = userModel.getUser_id();
            if (userId == null) {
                throw new RuntimeException();
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Authentication authentication1 = new UsernamePasswordAuthenticationToken(singInDto.email(), singInDto.password());
        Authentication authentication = authenticationManager.authenticate(authentication1);

        String token = jwtTokenProvider.generateToken(authentication);
        String role1 = userModel.getRole();
        String role = role1.substring(0, 1) + role1.substring(1).toLowerCase();
        return ResponseEntity.ok(new TokenAndUserIdDto(token, userId, role));
//        return token;
    }
}


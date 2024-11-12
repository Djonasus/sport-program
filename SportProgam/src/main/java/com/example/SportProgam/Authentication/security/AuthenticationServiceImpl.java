package com.example.SportProgam.Authentication.security;



import com.example.SportProgam.Authentication.dto.UserSingIRequestDto;
import com.example.SportProgam.Authentication.exception.BadRequestSingInCustomer;
import com.example.SportProgam.Authentication.exception.Validate;
import com.example.SportProgam.Authentication.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {


    private final AuthenticationManager authenticationManager;



//
//    @Override
//    public void signUp(RequestSingInGuestUserDto singUpDto) {
//        guestUserService.addAccount(singUpDto);
//    }


    @Override
    public void signIn(UserSingIRequestDto singInDto) {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    singInDto.email(),
                    singInDto.password())
            );
        } catch (BadCredentialsException e) {
            throw new BadRequestSingInCustomer(new Validate("Неверное имя пользователя или пароль")
            );
        }



    }
}

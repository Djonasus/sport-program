package com.example.SportProgam.Authentication.security;


import com.example.SportProgam.Authentication.dto.UserSingIRequestDto;

public interface AuthenticationService {

    // void signUp(RequestSingInGuestUserDto singUpDto);

    void signIn(UserSingIRequestDto singInDto);

}

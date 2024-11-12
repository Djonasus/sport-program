package com.example.SportProgam.Authentication.security;


import com.example.SportProgam.Authentication.dto.UserDetailInformationResponseDto;
import com.example.SportProgam.Authentication.dto.UserSingInRequestDto;
import com.example.SportProgam.Authentication.dto.UserSingUpRequestDto;

public interface AuthenticationService {

    void signUp(UserSingUpRequestDto singUpDto);

    UserDetailInformationResponseDto signIn(UserSingInRequestDto singInDto);

}

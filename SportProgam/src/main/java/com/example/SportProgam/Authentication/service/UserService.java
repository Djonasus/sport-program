package com.example.SportProgam.Authentication.service;

import com.example.SportProgam.Authentication.dto.UserDetailInformationResponseDto;
import com.example.SportProgam.Authentication.dto.UserSingUpRequestDto;
import com.example.SportProgam.Authentication.model.User;

import java.util.List;

public interface UserService {

    User save(UserSingUpRequestDto userSingUpRequestDto);

    User findUserByEmail(String email);
    UserDetailInformationResponseDto findUserInfByEmail(String email);

    User findUserById(Long id);



//   void update(User user, Long id);

    void  deleteUserById(Long id);
}

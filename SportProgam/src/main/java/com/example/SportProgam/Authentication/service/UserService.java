package com.example.SportProgam.Authentication.service;

import com.example.SportProgam.Authentication.dto.UserDetailInformationResponseDto;
import com.example.SportProgam.Authentication.dto.UserSingUpRequestDto;
import com.example.SportProgam.Authentication.model.UserModel;

public interface UserService {

    UserModel save(UserSingUpRequestDto userSingUpRequestDto);

    UserModel findUserByEmail(String email);
    UserDetailInformationResponseDto findUserInfByEmail(String email);

//    UserModel findUserByLogin(String login);

    UserModel findUserById(Long id);



//   void update(User user, Long id);

    void  deleteUserById(Long id);
}

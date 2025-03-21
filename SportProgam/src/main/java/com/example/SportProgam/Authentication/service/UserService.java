package com.example.SportProgam.Authentication.service;

import com.example.SportProgam.Authentication.dto.TokenAndUserIdDto;
import com.example.SportProgam.Authentication.dto.UserDetailInformationResponseDto;
import com.example.SportProgam.Authentication.dto.UserSingInRequestDto;
import com.example.SportProgam.Authentication.dto.UserSingUpRequestDto;
import com.example.SportProgam.Authentication.model.UserModel;
import com.example.SportProgam.user_package.dto.UserEventsDto;
import com.example.SportProgam.user_package.dto.UserInfoResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {

    UserModel save(UserSingUpRequestDto userSingUpRequestDto);

    UserModel findUserByEmail(String email);
    UserDetailInformationResponseDto findUserInfByEmail(String email);

//    UserModel findUserByLogin(String login);

    UserModel findUserById(Long id);



//   void update(User user, Long id);

    void  deleteUserById(Long id);

    UserInfoResponseDto findInfoByUserId(long userId);

    void savePhoto(long userId, MultipartFile multipartFile) throws IOException;

    List<UserEventsDto> findUserEvents(Long userid);

    String getRoleAsTittleCaseFromUser(UserModel userModel);

    TokenAndUserIdDto singUp(UserSingUpRequestDto singUpGuestUserDto);

    TokenAndUserIdDto loginIn(UserSingInRequestDto singInDto);
}

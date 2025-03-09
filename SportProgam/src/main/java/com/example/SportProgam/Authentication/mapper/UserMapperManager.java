package com.example.SportProgam.Authentication.mapper;

import com.example.SportProgam.Authentication.dto.UserDetailInformationResponseDto;
import com.example.SportProgam.Authentication.dto.UserSingUpRequestDto;
import com.example.SportProgam.Authentication.model.UserModel;

public interface UserMapperManager {

    UserDetailInformationResponseDto toDtoUserInfo(UserModel model);
    UserModel toDModel(UserSingUpRequestDto dto);
}

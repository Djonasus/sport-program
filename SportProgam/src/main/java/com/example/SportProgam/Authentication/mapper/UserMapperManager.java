package com.example.SportProgam.Authentication.mapper;

import com.example.SportProgam.Authentication.dto.UserDetailInformationResponseDto;
import com.example.SportProgam.Authentication.dto.UserSingUpRequestDto;
import com.example.SportProgam.Authentication.model.User;
import org.mapstruct.Mapping;

import java.lang.annotation.Target;

public interface UserMapperManager {

    UserDetailInformationResponseDto toDtoUserInfo(User model);
    User toDModel(UserSingUpRequestDto dto);
}

package com.example.SportProgam.Authentication.mapper;

import com.example.SportProgam.Authentication.dto.UserDetailInformationResponseDto;
import com.example.SportProgam.Authentication.dto.UserSingUpRequestDto;
import com.example.SportProgam.Authentication.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

//    @Mapping(target = "role", expression = "java(RoleSetting.getRoleHowString(model.getRole()))")
    UserDetailInformationResponseDto toDtoUserInfo(UserModel model);

    UserModel toDtoUser(UserSingUpRequestDto dto);
}

package com.example.SportProgam.Authentication.mapper;

import com.example.SportProgam.Authentication.dto.UserDetailInformationResponseDto;
import com.example.SportProgam.Authentication.dto.UserSingUpRequestDto;
import com.example.SportProgam.Authentication.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class UserMapperManagerImpl implements UserMapperManager {

    private final UserMapper userMapper;


    @Override
    public UserDetailInformationResponseDto toDtoUserInfo(UserModel model) {
        return userMapper.toDtoUserInfo(model);
    }

    @Override
    public UserModel toDModel(UserSingUpRequestDto dto) {
        return userMapper.toDtoUser(dto);
    }
}

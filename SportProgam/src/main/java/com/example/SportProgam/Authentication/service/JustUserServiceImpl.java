package com.example.SportProgam.Authentication.service;

import com.example.SportProgam.Authentication.dto.UserSingUpRequestDto;
import com.example.SportProgam.Authentication.mapper.UserMapperManager;
import com.example.SportProgam.Authentication.model.Role;
import com.example.SportProgam.Authentication.model.User;
import com.example.SportProgam.Authentication.repostiroy.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class JustUserServiceImpl implements JustUserService {

    private final UserRepository userRepository;
    private final UserMapperManager mapperManager;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void save(UserSingUpRequestDto dto) {
        User user = mapperManager.toDModel(dto);
        user.setRole(new Role(1L, "USER"));
        user.setPassword(passwordEncoder.encode(dto.password()));
        userRepository.save(user);
    }
}

package com.example.SportProgam.Authentication.service;



import com.example.SportProgam.Authentication.dto.UserDetailInformationResponseDto;
import com.example.SportProgam.Authentication.dto.UserSingUpRequestDto;
import com.example.SportProgam.Authentication.exception.UsernameAlreadyExistsException;
import com.example.SportProgam.Authentication.exception.Validate;
import com.example.SportProgam.Authentication.mapper.UserMapperManager;
import com.example.SportProgam.Authentication.model.User;
import com.example.SportProgam.Authentication.repostiroy.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapperManager userMapper;

    @Override
    @Transactional
    public User save(UserSingUpRequestDto dto) {
        User user = userMapper.toDModel(dto);
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        } catch (DataIntegrityViolationException exception) {
            throw new UsernameAlreadyExistsException(new Validate("Аккаунт с таким email уже зарегистрирован"));
        }
    }


    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь с почтой::%s не найден".formatted(email)));

    }

    @Override
    public UserDetailInformationResponseDto findUserInfByEmail(String email) {
        return userMapper.toDtoUserInfo(userRepository.findByEmail(email).orElseThrow(() -> new NoSuchElementException("Пользователь с почтой::%s не наaйден".formatted(email))));
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь с ID::%d не найден".formatted(id)));
    }



    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
//
//    @Override
//    @Transactional
//    public void update(User updateUser, Long id) {
//        try {
//
//            userRepository.findById(id).ifPresentOrElse(
//
//                    user -> {
//                        if (updateUser.getUsername() != null) user.setUsername(updateUser.getUsername());
//                        if (updateUser.getLastName() != null) user.setLastName(updateUser.getLastName());
//                        if (updateUser.getFirstName() != null) user.setFirstName(updateUser.getFirstName());
//                        if (updateUser.getPassword() != null)
//                            user.setPassword(passwordEncoder.encode(updateUser.getPassword()));
//                        if (updateUser.getRoles() != null && !updateUser.getRoles().isEmpty()) {
//                            userRepository.deleteAllRolesForUser(id);
//                            user.setRoles(updateUser.getRoles());
//                        }
//                    }, () -> {
//                        throw new UsernameNotFoundException(ConstantResponseExceptionText.NOT_FOUND_USER_BY_ID.formatted(id));
//                    }
//            );
//        } catch (DataIntegrityViolationException exception) {
//            throw new UsernameAlreadyExistsException(new Validate(ConstantResponseExceptionText.USERNAME_ALREADY_EXISTS));
//        }
    }



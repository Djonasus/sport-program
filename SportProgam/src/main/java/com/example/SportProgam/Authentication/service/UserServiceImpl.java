package com.example.SportProgam.Authentication.service;



import com.example.SportProgam.ApiConfig;
import com.example.SportProgam.Authentication.dto.TokenAndUserIdDto;
import com.example.SportProgam.Authentication.dto.UserDetailInformationResponseDto;
import com.example.SportProgam.Authentication.dto.UserSingInRequestDto;
import com.example.SportProgam.Authentication.dto.UserSingUpRequestDto;
import com.example.SportProgam.Authentication.exception.UsernameNotFoundException;
import com.example.SportProgam.Authentication.mapper.UserMapperManager;
import com.example.SportProgam.Authentication.model.UserModel;
import com.example.SportProgam.Authentication.repostiroy.UserRepository;
import com.example.SportProgam.Authentication.security.JwtTokenProvider;
import com.example.SportProgam.event_package.model.EventModel;
import com.example.SportProgam.event_package.model.TeamModel;
import com.example.SportProgam.event_package.service.TeamService;
import com.example.SportProgam.image_package.model.ImageModel;
import com.example.SportProgam.image_package.service.ImageService;
import com.example.SportProgam.user_package.dto.UserEventsDto;
import com.example.SportProgam.user_package.dto.UserInfoResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
    private final UserMapperManager userMapper;
    private final ImageService imageService;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;
    private final TeamService teamService;

    @Override
    public UserModel save(UserSingUpRequestDto dto) {
        UserModel userModel = userMapper.toDModel(dto);
        try {
            userModel.setActivated(false);
            userModel.setUser_id(userRepository.count() + 251_652);
            userModel.setRole("USER");
            userModel.setActivated(false);
//            userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
            return userRepository.save(userModel);
        } catch (Exception exception) {
            log.info("user already have");
            return null;
        }
    }

    @Override
    public UserModel findUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь с почтой::%s не найден".formatted(email)));

    }

    @Override
    public UserDetailInformationResponseDto findUserInfByEmail(String email) {
        return userMapper.toDtoUserInfo(userRepository.findByEmail(email).orElseThrow(() -> new NoSuchElementException("Пользователь с почтой::%s не наaйден".formatted(email))));
    }

//    @Override
//    public UserModel findUserByLogin(String login) {
//        return userRepository.findByLogin(login).orElseThrow(
//                () -> new UsernameNotFoundException("Пользователь с login::%s не найден".formatted(login)));
//    }

    @Override
    public UserModel findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь с ID::%d не найден".formatted(id)));
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserInfoResponseDto findInfoByUserId(long userId) {
        return mapperToUserInfoDto(findUserById(userId));

    }

    @Override
    public void savePhoto(long userId, MultipartFile multipartFile) throws IOException {
        UserModel userModel = findUserById(userId);
        userModel.setImageModel(imageService.saveUserAvatar(userModel, multipartFile));
    }

    @Override
    public List<UserEventsDto> findUserEvents(Long userId) {
        return convertTeamsToEventsDto(
                teamService.fingTeamListByUserId(userId)
        );
    }

    private UserEventsDto mapperEventToUserEventDto(EventModel eventModel) {
        return new UserEventsDto(
                eventModel.getEvent_id(),
                eventModel.getTitle(),
                eventModel.getType(),
                eventModel.getDate()
        );
    }

    private List<UserEventsDto> convertTeamsToEventsDto(List<TeamModel> teamModels) {
        List<UserEventsDto> result = new ArrayList<>();
        for (TeamModel teamModel : teamModels) {
            result.add(
                    mapperEventToUserEventDto(teamModel.getEvent())
            );
        }
        return result;
    }

    @Override
    public String getRoleAsTittleCaseFromUser(UserModel userModel) {
        String role = userModel.getRole();
        return role.charAt(0) + role.substring(1).toLowerCase();
    }

    @Override
    public TokenAndUserIdDto singUp(UserSingUpRequestDto singUpGuestUserDto) {
        UserModel userModel = save(singUpGuestUserDto);
        String token = jwtTokenProvider.generateToken(
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(singUpGuestUserDto.email(), singUpGuestUserDto.password())
                )
        );
        return new TokenAndUserIdDto(
                token, userModel.getUser_id(), getRoleAsTittleCaseFromUser(userModel));
    }

    @Override
    public TokenAndUserIdDto loginIn(UserSingInRequestDto singInDto) {
        UserModel userModel = findUserByEmail(singInDto.email());
        String token = jwtTokenProvider.generateToken(
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(singInDto.email(), singInDto.password())
                ));
        return new TokenAndUserIdDto(
                token, userModel.getUser_id(), getRoleAsTittleCaseFromUser(userModel));
    }

    private UserInfoResponseDto mapperToUserInfoDto(UserModel userModel) {
        long userImageId = checkUserImageId(userModel);
        log.info("userImageId is {}",userImageId);
        return new UserInfoResponseDto(
                userModel.getUser_id(),
                userModel.getEmail(),
                userModel.getPassword(),
                userModel.getName(),
                userModel.getLastName(),
                userModel.getRole(),
                "http://"+ ApiConfig.SERVER_IP + ":"+ApiConfig.SERVER_PORT+"/api/image/"+userImageId
        );
    }

    private long checkUserImageId(UserModel userModel) {
        if (userModel.getImageModel() == null) {
            log.info("if was be");
            return 11111L;
        }
        return userModel.getImageModel().getImageId();
    }
    }



package com.example.SportProgam.Authentication.security;

//import com.example.Java_Server_Part.model.UserModel;
//import com.example.Java_Server_Part.service.UserService;
import com.example.SportProgam.Authentication.model.UserModel;
import com.example.SportProgam.Authentication.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserModel userModel = userService.findUserByLogin(login);
        String currentPassword = userModel.getPassword();
        log.info("find by user name : {}, : password {}, role : {}", login, currentPassword, userModel.getRole());
        String encodedPassword = passwordEncoder.encode(currentPassword);
        Collection<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_" + userModel.getRole()));
        return new UserPrincipal(login, encodedPassword, authorities); // Убедитесь, что роли добавляются в UserPrincipal
    }
}


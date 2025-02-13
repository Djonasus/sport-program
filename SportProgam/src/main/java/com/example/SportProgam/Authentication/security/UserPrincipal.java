//package com.example.SportProgam.Authentication.security;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//
//public class UserPrincipal implements UserDetails {
//    private String login;
//    private String password;
//    private Collection<? extends GrantedAuthority> authorities;
//
//    public UserPrincipal(String login, String password, Collection<? extends GrantedAuthority> authorities) {
//        this.login = login;
//        this.password = password;
//        this.authorities = authorities;
//    }
//
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return login;
//    }
//
//    // Реализация других методов из интерфейса UserDetails
//}
//

package com.example.SportProgam.Authentication.service;

import com.example.SportProgam.Authentication.model.User;

import java.util.List;

public interface UserService {

    User save(User user);

    User findUserByEmail(String email);

    User findUserById(Long id);



//   void update(User user, Long id);

    void  deleteUserById(Long id);
}

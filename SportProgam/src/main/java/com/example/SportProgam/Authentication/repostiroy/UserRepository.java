package com.example.SportProgam.Authentication.repostiroy;

import com.example.SportProgam.Authentication.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByEmail(String email);

//    Optional<UserModel> findByLogin(String login);
}

package com.example.SportProgam.Authentication.mapper;


import com.example.SportProgam.Authentication.model.Role;
import org.springframework.stereotype.Component;


public final class RoleSetting {

    public static String  getRoleHowString(Role role){
         return role != null ? role.getRoleName() : "";
    }


    //@TODO
    public static Role  getRoleHowRole(String role){
        return new Role(1L, role);
    }
}

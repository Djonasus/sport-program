package com.example.SportProgam.Authentication.model;


import com.example.SportProgam.event_package.model.EventModel;
import com.example.SportProgam.event_package.model.TeamModel;
import jakarta.persistence.*;
import lombok.*;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

//import java.util.Collection;
//import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserModel{

    @Id
    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    private String name;
    @Column(name = "last_name")
    private String lastName;


    @Column(name = "activated")
    private boolean activated;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "user")
    private List<TeamModel> teams;

    @OneToMany(mappedBy = "referee")
    private List<EventModel> eventsAsReferee;

//    private ImageM avatar;

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return role == null ? List.of() : Collections.singleton(new SimpleGrantedAuthority(role.getRoleName()));
//    }

//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return email;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return UserDetails.super.isAccountNonExpired();
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return UserDetails.super.isAccountNonLocked();
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return UserDetails.super.isCredentialsNonExpired();
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return UserDetails.super.isEnabled();
//    }
//
//    public String toString() {
//        return "User(id=" + this.getId() + " username=" + this.getUsername() + ", password=" + this.getPassword() + ", roles=";
//    }
}

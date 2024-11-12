
package com.example.SportProgam.Authentication.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "role")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Role {


    @Id
    @Column(name = "role_id")
    private Long id;

    @Column(name = "role_name", unique = true)
    private String roleName;


}

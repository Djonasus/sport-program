package com.example.SportProgam.image_package.model;

import com.example.SportProgam.Authentication.model.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "images")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImageModel {
    @Id
    @Column(name = "image_id")
    private Long imageId;
    @OneToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "user_id")
    private UserModel userModel;
}

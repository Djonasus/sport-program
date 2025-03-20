package com.example.SportProgam.image_package.repository;

import com.example.SportProgam.image_package.model.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<ImageModel, Long> {
    @Query(nativeQuery = true, value = "select * from \"public\".images where images.user_id=:userId;")
    ImageModel findByUserModel(Long userId);
}

package com.example.SportProgam.image_package.service;

import com.example.SportProgam.Authentication.model.UserModel;
import com.example.SportProgam.image_package.model.ImageModel;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {

    byte[] save(Long photoId, MultipartFile multipartFile) throws IOException;

    byte[] get(Long photoId) throws IOException;

    Object delete(Long photoId);

    MultiValueMap<String, String> getContentTypeImage();

    ImageModel saveUserAvatar(UserModel userId, MultipartFile multipartFile) throws IOException;

    long saveNewsImage(MultipartFile multipartFile) throws IOException;
}

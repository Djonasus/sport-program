package com.example.SportProgam.image_package.service;

import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {

    byte[] save(Long photoId, MultipartFile multipartFile) throws IOException;

    byte[] get(Long photoId) throws IOException;

    Object delete(Long photoId);

    MultiValueMap<String, String> getContentTypeImage();
}

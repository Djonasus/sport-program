package com.example.SportProgam.service;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {

    ResponseEntity<FileSystemResource> save(Long photoId, MultipartFile multipartFile) throws IOException;

    ResponseEntity<FileSystemResource> get(Long photoId);

    Object delete(Long photoId);

}

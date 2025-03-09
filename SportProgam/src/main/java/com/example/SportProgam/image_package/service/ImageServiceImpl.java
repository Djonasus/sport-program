package com.example.SportProgam.image_package.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE_NEW;

@Service
public class ImageServiceImpl implements ImageService {

    @Value("${path.image}")
    private String imageDir;

    @Override
    public ResponseEntity<FileSystemResource> save(Long photoId, MultipartFile multipartFile) throws IOException {
        Path filePath = Path.of(imageDir, photoId + ".jpg");
        Files.createDirectories(filePath.getParent());
        Files.deleteIfExists(filePath);
        try
                (InputStream is = multipartFile.getInputStream();
                 OutputStream os = Files.newOutputStream(filePath, CREATE_NEW);
                 BufferedInputStream bis = new BufferedInputStream(is, 1024);
                 BufferedOutputStream bos = new BufferedOutputStream(os, 1024);
                ) {
            bis.transferTo(bos);
        }
        return get(photoId);
    }

    @Override
    public ResponseEntity<FileSystemResource> get(Long photoId) {
        File imageFile = new File(imageDir, photoId + ".jpg");
        FileSystemResource resource = new FileSystemResource(imageFile);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept-Ranges", "bytes");
        headers.set("Content-Length", String.valueOf(imageFile.length()));
        headers.setContentType(MediaType.IMAGE_JPEG);

        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }

    @Override
    public Object delete(Long photoId) {
        File imageFile = new File(imageDir, photoId + ".jpg"); // Замените "photo.jpg" на имя вашего файла
        return new FileSystemResource(imageFile);
    }
}

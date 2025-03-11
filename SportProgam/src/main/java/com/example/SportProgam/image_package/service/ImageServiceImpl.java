package com.example.SportProgam.image_package.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE_NEW;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

    @Value("${path.image}")
    private String imageDir;

    @Override
    public byte[] save(Long photoId, MultipartFile multipartFile) throws IOException {
        Path filePath = Path.of(imageDir, photoId + ".jpeg");
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
    public byte[] get(Long photoId) throws IOException {
        File imageFile = new File(imageDir, photoId + ".jpeg");
        if (!imageFile.exists()) {
            imageFile = new File(imageDir, 11_111 + ".jpeg");
        }

        //        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.IMAGE_JPEG);
//        FileSystemResource resource = new FileSystemResource(imageFile);

//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Accept-Ranges", "bytes");
//        headers.set("Content-Length", String.valueOf(imageFile.length()));
//        headers.setContentType(MediaType.IMAGE_JPEG);
        return (byte[]) Files.readAllBytes(imageFile.toPath());
    }

    @Override
    public Object delete(Long photoId) {
        File imageFile = new File(imageDir, photoId + ".jpeg"); // Замените "photo.jpg" на имя вашего файла
        return new FileSystemResource(imageFile);
    }

    @Override
    public MultiValueMap<String, String> getContentTypeImage() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return headers;
    }
}

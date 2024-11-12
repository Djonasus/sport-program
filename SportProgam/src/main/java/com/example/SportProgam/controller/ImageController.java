package com.example.SportProgam.controller;

import com.example.SportProgam.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/image")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @PostMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<FileSystemResource> save(@PathVariable long id,
                                                   @RequestPart MultipartFile multipartFile) throws IOException {
        return imageService.save(id, multipartFile);
    }

    @GetMapping("/{photoId}")
    public ResponseEntity<?> getPhoto(@PathVariable Long photoId) {


        return imageService.get(photoId);
    }

}

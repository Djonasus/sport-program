package com.example.SportProgam.image_package.controller;

import com.example.SportProgam.image_package.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/image")
@RequiredArgsConstructor
//@CrossOrigin(origins = "http://localhost:3000")
public class ImageController {

    private final ImageService imageService;

    @CrossOrigin("*")
    @PostMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<FileSystemResource> save(@PathVariable long id,
                                                   @RequestPart MultipartFile multipartFile) throws IOException {
        return imageService.save(id, multipartFile);
    }
    @CrossOrigin("*")
    @GetMapping("/{photoId}")
    public ResponseEntity<?> getPhoto(@PathVariable Long photoId) {
        return imageService.get(photoId);
    }

}

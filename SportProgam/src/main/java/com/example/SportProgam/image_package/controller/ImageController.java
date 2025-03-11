package com.example.SportProgam.image_package.controller;

import com.example.SportProgam.image_package.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
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

    private static final Logger log = LoggerFactory.getLogger(ImageController.class);
    private final ImageService imageService;

    @CrossOrigin("*")
    @PostMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> save(@PathVariable long id,
                                                   @RequestPart MultipartFile multipartFile) throws IOException {
        return new ResponseEntity<>(imageService.save(id, multipartFile),
                imageService.getContentTypeImage(),
                HttpStatus.OK);
    }
    @CrossOrigin("*")
    @GetMapping("/{photoId}")
    public ResponseEntity<?> getPhoto(@PathVariable Long photoId) throws IOException {
        return new ResponseEntity<>(
                imageService.get(photoId),
                imageService.getContentTypeImage(),
                HttpStatus.OK);
//        return imageService.get(photoId);
    }

}

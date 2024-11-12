package com.example.SportProgam.Coordinates.controller;


import com.example.SportProgam.Authentication.service.UserService;
import com.example.SportProgam.Coordinates.dto.TypeResponseDto;
import com.example.SportProgam.Coordinates.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api/type")
@RequiredArgsConstructor
public class TypeRestController {

    private final TypeService typeService;


    @GetMapping("/all")
    public ResponseEntity<List<TypeResponseDto>> getAllTypes(){
        return ResponseEntity.ok().body(
                typeService.findAllTypes()
        );
    }

}

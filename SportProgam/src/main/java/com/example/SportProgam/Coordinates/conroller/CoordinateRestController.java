package com.example.SportProgam.Coordinates.conroller;


import com.example.SportProgam.Coordinates.dto.CoordinateRequestDto;
import com.example.SportProgam.Coordinates.dto.CoordinateResponseDto;
import com.example.SportProgam.Coordinates.service.CoordinateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/coordinates/")
@RequiredArgsConstructor
public class CoordinateRestController {

    private final CoordinateService coordinateService;

    @CrossOrigin("*")
    @GetMapping("/all")
    public ResponseEntity<List<CoordinateResponseDto>> getAllCoordinate(){
        return ResponseEntity.ok(coordinateService.findAllCoordinates());
    }
    @CrossOrigin("*")
    @PostMapping()
    public ResponseEntity<Void> addCoordinate(@RequestBody CoordinateRequestDto dto){
        coordinateService.create(dto);
        return ResponseEntity.noContent().build();
    }

}

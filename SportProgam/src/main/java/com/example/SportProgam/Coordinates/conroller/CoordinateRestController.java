package com.example.SportProgam.Coordinates.conroller;


import com.example.SportProgam.Coordinates.dto.CoordinateRequestDto;
import com.example.SportProgam.Coordinates.dto.CoordinateResponseDto;
import com.example.SportProgam.Coordinates.service.CoordinateService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/coordinates/")
@RequiredArgsConstructor
public class CoordinateRestController {

    private static final Logger log = LoggerFactory.getLogger(CoordinateRestController.class);
    private final CoordinateService coordinateService;

    @CrossOrigin("*")
//    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @GetMapping("/all")
    public ResponseEntity<List<CoordinateResponseDto>> getAllCoordinate(){
//        log.info("coord");
        return ResponseEntity.ok(coordinateService.findAllCoordinates());
    }
    @CrossOrigin("*")
//    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @PostMapping()
    public ResponseEntity<Void> addCoordinate(@RequestBody CoordinateRequestDto dto){
//        log.info("coord3");
        coordinateService.create(dto);
        return ResponseEntity.noContent().build();
    }

}

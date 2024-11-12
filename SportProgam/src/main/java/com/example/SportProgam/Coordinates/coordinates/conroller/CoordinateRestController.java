package com.example.SportProgam.Coordinates.coordinates.conroller;


import com.example.SportProgam.Coordinates.coordinates.dto.CoordinateAllResponseDto;
import com.example.SportProgam.Coordinates.coordinates.dto.CoordinateRequestDto;
import com.example.SportProgam.Coordinates.coordinates.service.CoordinateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/placemark")
@RequiredArgsConstructor
public class CoordinateRestController {

    private final CoordinateService coordinateService;


    @GetMapping()
    public ResponseEntity<CoordinateAllResponseDto> getAllCoordinate(){
        return ResponseEntity.ok()
                .body(
                        new CoordinateAllResponseDto(
                                coordinateService.finaAllCoordinate()
                        )
                );
    }
    @PostMapping()
    public ResponseEntity<Void> addCoordinate(@RequestBody CoordinateRequestDto dto){
        coordinateService.create(dto);
        return ResponseEntity.noContent().build();
    }

}

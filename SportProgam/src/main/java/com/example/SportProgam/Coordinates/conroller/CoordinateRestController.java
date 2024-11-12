package com.example.SportProgam.Coordinates.conroller;


import com.example.SportProgam.Coordinates.dto.CoordinateAllResponseDto;
import com.example.SportProgam.Coordinates.dto.CoordinateRequestDto;
import com.example.SportProgam.Coordinates.service.CoordinateService;
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

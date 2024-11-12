package com.example.SportProgam.Coordinates.repository;

import com.example.SportProgam.Coordinates.model.Coordinate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordinateRepository extends JpaRepository<Coordinate, Long> {
}

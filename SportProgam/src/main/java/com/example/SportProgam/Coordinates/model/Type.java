package com.example.SportProgam.Coordinates.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "type")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coordinate_id")
    private Long id;

    private String title;
}

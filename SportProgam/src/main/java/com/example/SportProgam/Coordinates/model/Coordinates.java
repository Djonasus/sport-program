package com.example.SportProgam.Coordinates.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "coordinate")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Coordinates {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coordinate_id")
    private Long id;

    private Double x;

    private Double y;

    private String description;

    @ManyToOne()
    @JoinColumn(name = "coordinate_id")
    private Type type;

}

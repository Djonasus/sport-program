package com.example.SportProgam.Coordinates.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "type_of_event")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class    TypeOfEventModel {

    @Id
    private Long type_id;
    private String type;

    @ManyToOne
    @JoinColumn(name = "coordinate_id")
    private CoordinateModel coordinate;

}

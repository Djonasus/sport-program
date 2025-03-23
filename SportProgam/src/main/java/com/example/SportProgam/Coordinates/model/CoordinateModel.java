package com.example.SportProgam.Coordinates.model;


import com.example.SportProgam.event_package.model.EventModel;
import com.example.SportProgam.event_package.model.EventRequestModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "coordinates")
@AllArgsConstructor
@NoArgsConstructor
//@Builder
@Data
public class CoordinateModel {


    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coordinate_id")
    private Long coordinateid;

    private Double x;

    private Double y;

    private String name;

    private String description;

    @OneToMany(mappedBy = "coordinates")
    private List<EventModel> events;

    @OneToMany(mappedBy = "coordList")
    private List<EventRequestModel> eventRequestModels;

    @OneToMany(mappedBy = "coordinate")
    private List<TypeOfEventModel> typeOfEventModels;

}

package com.example.SportProgam.event_package.model;

import com.example.SportProgam.Authentication.model.UserModel;
import com.example.SportProgam.Coordinates.model.CoordinateModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "events")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventModel {

    @Id
    private long event_id;
    private String title;
    private String description;

    @OneToMany(mappedBy = "event")
    private List<TeamModel> teams;

    private String date;
    private String time;

    @ManyToOne
    @JoinColumn(name = "referee_volunteer_id")
    private UserModel referee;
    private int maxCountInOneTeam;

    @ManyToOne
    @JoinColumn(name = "coordinates_id")
    private CoordinateModel coordinates;

}

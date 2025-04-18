package com.example.SportProgam.event_package.model;

import com.example.SportProgam.Authentication.model.UserModel;
import com.example.SportProgam.Coordinates.model.CoordinateModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "events")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventModel {

    @Id
    private Long event_id;
    private String title;
    private String description;

    @OneToMany(mappedBy = "event")
    private List<TeamModel> teams;

    private String date;
    private String time;
    private String type;

    @ManyToOne
    @JoinColumn(name = "referee_volunteer_id")
    private UserModel referee;
    private int maxCountInOneTeam;

    @ManyToOne
    @JoinColumn(name = "coordinates_id")
    private CoordinateModel coordinates;

}

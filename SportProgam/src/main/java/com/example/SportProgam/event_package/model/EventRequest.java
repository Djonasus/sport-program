package com.example.SportProgam.event_package.model;

import com.example.SportProgam.Authentication.model.UserModel;
import com.example.SportProgam.Coordinates.model.CoordinateModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "event_requests")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventRequest {

    @Id
    private long event_request_id;
    private String title;
    private String description;

    private String date;
    private String time;
    private String type;

    private int maxCountInOneTeam;

    @ManyToOne
    @JoinColumn(name = "coordinates_id")
    private CoordinateModel coordList;

}

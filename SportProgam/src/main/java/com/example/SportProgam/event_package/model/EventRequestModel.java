package com.example.SportProgam.event_package.model;

import com.example.SportProgam.Coordinates.model.CoordinateModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "event_requests")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventRequestModel {

    @Id
    private long event_request_id;
    private String title;
    private String description;

    private String date;
    private String time;
    private String type;

    @Column(name = "creator_id")
    private Long creatorId;
    private int maxCountInOneTeam;

    @ManyToOne
    @JoinColumn(name = "coordinates_id")
    private CoordinateModel coordList;

}

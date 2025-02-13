package com.example.SportProgam.event_package.model;

import com.example.SportProgam.Authentication.model.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "teams")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamModel {
    @Id
    @Column(name = "team_id")
    private Long teamId;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private EventModel event;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    @Column(name = "team_num")
    private Integer teamNum;

}

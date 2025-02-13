package com.example.SportProgam.event_package.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventForUserResponseDto {

    private String title;
    private String description;
    private List<UserDto> team1;
    private List<UserDto> team2;
    private String date;
    private String time;
    private String referee;
    private int maxCountInOneTeam;

}

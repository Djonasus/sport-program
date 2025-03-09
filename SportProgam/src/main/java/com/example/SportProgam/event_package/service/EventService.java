package com.example.SportProgam.event_package.service;

import com.example.SportProgam.ApiConfig;
import com.example.SportProgam.event_package.dto.EventForUserResponseDto;
//import com.example.SportProgam.event_package.dto.TeamDto;
import com.example.SportProgam.event_package.dto.UserDto;
import com.example.SportProgam.event_package.model.EventModel;
import com.example.SportProgam.event_package.model.TeamModel;
import com.example.SportProgam.event_package.repository.EventRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository repository;

    public EventForUserResponseDto getEventInfo(long eventId) {
        EventModel eventModel = repository.findById(eventId).get();
        List<TeamModel> teams = eventModel.getTeams();
        List<List<UserDto>> teamDtoList = getListTwoTeamsDto(teams);
        teamDtoList = addMinuses(teamDtoList, eventModel.getMaxCountInOneTeam());
        List<UserDto> team1 = teamDtoList.getFirst();
        List<UserDto> team2 = teamDtoList.getLast();

        return new EventForUserResponseDto(
                eventModel.getTitle(),
                eventModel.getDescription(),
                team1, team2,
                eventModel.getDate(),
                eventModel.getTime(),
                eventModel.getReferee().getEmail(),
                eventModel.getMaxCountInOneTeam()
        );

//        return new EventForUserResponseDto();
    }

    private List<List<UserDto>> addMinuses(List<List<UserDto>> teamDtoList, int max) {
        String url = "http://" + ApiConfig.SERVER_IP + ":" + ApiConfig.SERVER_PORT;
        List<UserDto> team1 = new ArrayList<>(List.copyOf(teamDtoList.getFirst()));
        if (team1.size() < max) {
            while (team1.size() < max) {
                team1.add(new UserDto(0L, "-", "-", url +"/api/image/11111"));
            }
        }
        List<UserDto> team2 = new ArrayList<>(List.copyOf(teamDtoList.getLast()));
        if (team2.size() < max) {
            while (team2.size() < max) {
                team2.add(new UserDto(0L, "-", "-", url +"/api/image/11111"));
            }
        }

        return List.of(
                team1, team2
        );
    }

    private List<List<UserDto>> getListTwoTeamsDto(List<TeamModel> teams) {
        String url = "http://" + ApiConfig.SERVER_IP + ":" + ApiConfig.SERVER_PORT;
        List<UserDto> userDtoList1 = new ArrayList<>();
        List<UserDto> userDtoList2 = new ArrayList<>();
        for (TeamModel team : teams) {
            if (team.getTeamNum().equals(1)) {
                userDtoList1.add(new UserDto(
                        team.getUser().getUser_id(),
                        team.getUser().getName(),
                        team.getUser().getLastName(),
                        url +"/api/image/22222"
                ));
            } else {
                userDtoList2.add(new UserDto(
                        team.getUser().getUser_id(),
                        team.getUser().getName(),
                        team.getUser().getLastName(),
                        url +"/api/image/22222"
                ));
            }
        }
        return List.of(
                userDtoList1,
                userDtoList2
        );

    }
}

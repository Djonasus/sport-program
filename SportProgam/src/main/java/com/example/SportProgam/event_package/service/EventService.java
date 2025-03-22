package com.example.SportProgam.event_package.service;

import com.example.SportProgam.ApiConfig;
import com.example.SportProgam.Authentication.model.UserModel;
import com.example.SportProgam.Authentication.repostiroy.UserRepository;
import com.example.SportProgam.Coordinates.repository.CoordinateRepository;
import com.example.SportProgam.event_package.dto.CreateEventRequestDto;
import com.example.SportProgam.event_package.dto.EventForUserResponseDto;
//import com.example.SportProgam.event_package.dto.TeamDto;
import com.example.SportProgam.event_package.dto.RequestToEventDto;
import com.example.SportProgam.event_package.dto.UserDto;
import com.example.SportProgam.event_package.model.EventModel;
import com.example.SportProgam.event_package.model.TeamModel;
import com.example.SportProgam.event_package.repository.EventRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final TeamService teamService;
    private final UserRepository userRepository;
    private final CoordinateRepository coordinateRepository;
    private final EventRequestService eventRequestService;
    private final String IMAGE_URL = "http://" + ApiConfig.SERVER_IP + ":" + ApiConfig.SERVER_PORT + "/api/image/";

    public EventForUserResponseDto getEventInfo(long eventId) {
        EventModel eventModel = eventRepository.findById(eventId).get();
//        List<TeamModel> teams = eventModel.getTeams();
//        List<List<UserDto>> teamDtoList = getListTwoTeamsDto(teams);
//        teamDtoList = addMinuses(teamDtoList, eventModel.getMaxCountInOneTeam());
        List<List<UserDto>> teamDtoList = createTeamDtoListByEventModel(eventModel);
        return new EventForUserResponseDto(
                eventModel.getTitle(),
                eventModel.getDescription(),
                teamDtoList.getFirst(),
                teamDtoList.getLast(),
                eventModel.getDate(),
                eventModel.getTime(),
                eventModel.getReferee().getEmail(),
                eventModel.getMaxCountInOneTeam()
        );
    }

    private List<List<UserDto>> createTeamDtoListByEventModel(EventModel eventModel) {
        List<TeamModel> teams = eventModel.getTeams();
        List<List<UserDto>> teamDtoList = getListTwoTeamsDto(teams);
        return addMinuses(teamDtoList, eventModel.getMaxCountInOneTeam());
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
        List<UserDto> userDtoList1 = new ArrayList<>();
        List<UserDto> userDtoList2 = new ArrayList<>();
        for (TeamModel team : teams) {
            if (team.getTeamNum().equals(1)) {
                userDtoList1.add(createUserDtoByTeam(team));
            } else {
                userDtoList2.add(createUserDtoByTeam(team));
            }
        }
        return List.of(
                userDtoList1,
                userDtoList2
        );

    }

    private UserDto createUserDtoByTeam(TeamModel team) {
        UserModel user = team.getUser();
        return new UserDto(
                user.getUser_id(),
                user.getName(),
                user.getLastName(),
                IMAGE_URL + checkUserImageId(user)
        );
    }
    private long checkUserImageId(UserModel userModel) {
        if (userModel.getImageModel() == null) {
            return 11111L;
        }
        return userModel.getImageModel().getImageId();
    }

    public void requestToEvent(RequestToEventDto dto) {
        if (!checkByAlreadyExist(dto.eventId(), dto.userId())) {
            teamService.save(dto, eventRepository.findById(dto.eventId()).get());
            return;
        }
        throw new RuntimeException();
    }

    private boolean checkByAlreadyExist(Long eventId, Long userId) {
        TeamModel teamModel = teamService.findTeamListByUserIdAndEventId(userId, eventId);
        return teamModel != null;
    }

    public void createEventByDto(CreateEventRequestDto requestDto, String username) {
        log.info("request dto is: {}", requestDto.toString());
        if (userRepository.findByEmail(username).get().getRole().equals("ADMIN")) {
            eventRepository.save(mapperEventDtoToEventModel(requestDto));
            return;
        }
        eventRequestService.save(requestDto);

    }

    private EventModel mapperEventDtoToEventModel(CreateEventRequestDto requestDto) {
        return new EventModel(
                eventRepository.count()+1,
                requestDto.title(),
                requestDto.description(),
                null,
                requestDto.date(),
                requestDto.time(),
                requestDto.sport(),
                userRepository.findById(requestDto.userId()).get(),
                requestDto.maxCount(),
                coordinateRepository.findById(requestDto.coordId()).get()
        );
    }
}

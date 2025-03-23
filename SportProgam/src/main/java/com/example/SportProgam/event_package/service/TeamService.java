package com.example.SportProgam.event_package.service;

import com.example.SportProgam.Authentication.repostiroy.UserRepository;
import com.example.SportProgam.event_package.dto.RequestToEventDto;
import com.example.SportProgam.event_package.model.EventModel;
import com.example.SportProgam.event_package.model.TeamModel;
import com.example.SportProgam.event_package.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeamService {

    private final TeamRepository teamRepository;
    private final UserRepository userRepository;

    public void save(RequestToEventDto dto, EventModel eventModel) {
        try {
            log.info(dto.toString());
            checkIfEventEnought(eventModel, dto.team());

            if (eventModel == null) {
                log.warn("error at event null");
                throw new RuntimeException();
            }
            teamRepository.save(
                    new TeamModel(
                            teamRepository.count()+1,
                            eventModel,
                            userRepository.findById(dto.userId()).get(),
                            dto.team()
                    )
            );
        } catch (Exception e) {
            log.warn("error save team model");
            throw new RuntimeException();
        }
    }

    private void checkIfEventEnought(EventModel eventModel, Integer team) {
        List<TeamModel> teamModels = teamRepository.findAllByEvent(eventModel.getEvent_id());
        int maxCountInOneTeam = eventModel.getMaxCountInOneTeam();
        int count = 0;
        for (TeamModel teamModel : teamModels) {
            log.warn("here");
            if (teamModel.getTeamNum() == team.longValue()) {
                count++;
                log.info("");
            }
        }
        log.info("count{}", count);
        if (count == maxCountInOneTeam) {
            throw new RuntimeException();
        }

    }

    public List<TeamModel> findTeamListByUserId(Long userId) {
        return teamRepository.findAllTeamsByUserId(userId);
    }

    public TeamModel findTeamListByUserIdAndEventId(Long userId, Long eventId) {
        for (TeamModel teamModel : findTeamListByUserId(userId)) {
            if (teamModel.getEvent().getEvent_id().equals(eventId)) {
                return teamModel;
            }
        }
        return null;

    }
}

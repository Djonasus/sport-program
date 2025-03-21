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
        }
    }

    public List<TeamModel> fingTeamListByUserId(Long userId) {
        return teamRepository.findAllTeamsByUserId(userId);
    }

}

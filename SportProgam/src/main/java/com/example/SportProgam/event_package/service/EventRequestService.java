package com.example.SportProgam.event_package.service;

import com.example.SportProgam.Authentication.repostiroy.UserRepository;
import com.example.SportProgam.Coordinates.repository.CoordinateRepository;
import com.example.SportProgam.admin_package.dto.RequestEventResponseDto;
import com.example.SportProgam.event_package.dto.CreateEventRequestDto;
import com.example.SportProgam.event_package.model.EventModel;
import com.example.SportProgam.event_package.model.EventRequestModel;
import com.example.SportProgam.event_package.repository.EventRepository;
import com.example.SportProgam.event_package.repository.EventRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventRequestService {

    private final EventRequestRepository eventRequestRepository;
    private final CoordinateRepository coordinateRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    public void save(CreateEventRequestDto requestDto) {
        eventRequestRepository.save(
                new EventRequestModel(
                        eventRequestRepository.count()+1,
                        requestDto.title(),
                        requestDto.description(),
                        requestDto.date(),
                        requestDto.time(),
                        requestDto.sport(),
                        requestDto.userId(),
                        requestDto.maxCount(),
                        coordinateRepository.findById(requestDto.coordId()).get()

                )
        );
    }

    public List<RequestEventResponseDto> getAllRequestEvents() {

        List<RequestEventResponseDto> result = new ArrayList<>();
        for (EventRequestModel eventRequestModel : getAllRequestFromBD()) {
            result.add(convertToDto(eventRequestModel));
        }
        return result;
    }

    private RequestEventResponseDto convertToDto(EventRequestModel eventRequestModel) {
        return new RequestEventResponseDto(
                eventRequestModel.getEvent_request_id(),
                eventRequestModel.getTitle(),
                eventRequestModel.getDescription(),
                eventRequestModel.getDate(),
                eventRequestModel.getTime(),
                eventRequestModel.getType(),
                findUserNameById(eventRequestModel.getCreatorId()),
                eventRequestModel.getMaxCountInOneTeam()
        );
    }

    private String findUserNameById(Long creatorId) {
        try {
            return userRepository.findById(creatorId).get().getName();
        } catch (Exception e) {
            return " - ";
        }
    }

    private List<EventRequestModel> getAllRequestFromBD() {
        return eventRequestRepository.findAll();
    }

    public void getAccessToEvent(Long eventId, boolean trueOrFalse) {
        if (trueOrFalse) {
            saveEventByEventRequestId(eventId);
        }
        deleteEventRequest(eventId);
    }

    private void deleteEventRequest(Long eventId) {
        eventRequestRepository.deleteById(eventId);
    }

    private void saveEventByEventRequestId(Long eventId) {
        EventRequestModel eventRequestModel = eventRequestRepository.findById(eventId).get();
        EventModel eventModel = mapperEventRequestToEventModel(eventRequestModel);
        eventRepository.save(eventModel);
    }

    private EventModel mapperEventRequestToEventModel(EventRequestModel eventRequestModel) {
        return new EventModel(
                eventRepository.count()+1,
                eventRequestModel.getTitle(),
                eventRequestModel.getDescription(),
                null,
                eventRequestModel.getDate(),
                eventRequestModel.getTime(),
                eventRequestModel.getType(),
                null,
                eventRequestModel.getMaxCountInOneTeam(),
                eventRequestModel.getCoordList()
        );
    }
}

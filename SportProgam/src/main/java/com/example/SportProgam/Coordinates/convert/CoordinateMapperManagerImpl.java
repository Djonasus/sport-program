package com.example.SportProgam.Coordinates.convert;

import com.example.SportProgam.Coordinates.dto.CoordinateRequestDto;
import com.example.SportProgam.Coordinates.dto.CoordinateResponseDto;
import com.example.SportProgam.Coordinates.dto.EventLittleInfo;
import com.example.SportProgam.Coordinates.model.CoordinateModel;
import com.example.SportProgam.event_package.model.EventModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;



@Component
@RequiredArgsConstructor
public class CoordinateMapperManagerImpl implements CoordinateMapperManager {

    private final CoordinateMapper coordinateMapper;
    private final CoordinateListMapper coordinateListMapper;

    @Override
    public CoordinateModel toModel(CoordinateRequestDto dto) {
        return coordinateMapper.toModel(dto);
    }

    @Override
    public CoordinateResponseDto toDto(CoordinateModel model) {
        return coordinateMapper.toDto(model);
    }

    @Override
    public List<CoordinateResponseDto> toDto(List<CoordinateModel> model) {
        List<CoordinateResponseDto> result = new ArrayList<>();
        for (CoordinateModel coordinateModel : model) {
            result.add(
                    new CoordinateResponseDto(
                            coordinateModel.getCoordinateid(),
                            List.of(coordinateModel.getX(), coordinateModel.getY()),
                            coordinateModel.getName(),
                            coordinateModel.getDescription(),
                            getEventsInfoDto(coordinateModel.getEvents())
                    )
            );
        }

        return result;
    }

    private List<EventLittleInfo> getEventsInfoDto(List<EventModel> events) {
        List<EventLittleInfo> result = new ArrayList<>();
        for (EventModel event : events) {
            result.add(
                    new EventLittleInfo(
                            event.getDate() + " " + event.getTime(),
                            event.getTitle(),
                            "type",
                            event.getEvent_id()
                    )
            );

        }
        return result;
    }
}

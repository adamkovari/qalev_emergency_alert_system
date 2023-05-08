package com.qualysoft.devops.seminar.qalevreportservice.dto.mapper;

import com.qualysoft.devops.seminar.qalevreportservice.dto.model.EventDto;
import com.qualysoft.devops.seminar.qalevreportservice.model.Event;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.qualysoft.devops.seminar.qalevreportservice.dto.mapper.EventTypeMapper.toEventTypeDto;

public class EventMapper {

    public static EventDto toEventDto(Event event) {
        return new EventDto()
                .setType(toEventTypeDto(event.getType()))
                .setStatus(event.getStatus())
                .setAlerts(event.getAlerts().stream()
                        .map(AlertMapper::toAlertDto)
                        .collect(Collectors.toList()));
    }
}
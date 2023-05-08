package com.qualysoft.devops.seminar.qalevreportservice.dto.mapper;

import com.qualysoft.devops.seminar.qalevreportservice.dto.model.AcknowledgerRoleDto;
import com.qualysoft.devops.seminar.qalevreportservice.dto.model.EventTypeDto;
import com.qualysoft.devops.seminar.qalevreportservice.model.EventType;
import org.modelmapper.ModelMapper;

import java.util.HashSet;
import java.util.stream.Collectors;

public class EventTypeMapper {
    public static EventTypeDto toEventTypeDto(EventType eventType) {
        return new EventTypeDto()
                .setName(eventType.getName())
                .setJurisdiction(new HashSet<AcknowledgerRoleDto>(
                        eventType.getJurisdiction()
                                .stream()
                                .map(ackRole -> new ModelMapper().map(ackRole, AcknowledgerRoleDto.class))
                                .collect(Collectors.toSet())));
    }
}
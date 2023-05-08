package com.qualysoft.devops.seminar.qalevreportservice.service;

import com.qualysoft.devops.seminar.qalevreportservice.dto.mapper.EventTypeMapper;
import com.qualysoft.devops.seminar.qalevreportservice.dto.model.AcknowledgerRoleDto;
import com.qualysoft.devops.seminar.qalevreportservice.dto.model.EventTypeDto;
import com.qualysoft.devops.seminar.qalevreportservice.exception.CustomException;
import com.qualysoft.devops.seminar.qalevreportservice.exception.CustomException.DuplicateEntityException;
import com.qualysoft.devops.seminar.qalevreportservice.model.AcknowledgerRole;
import com.qualysoft.devops.seminar.qalevreportservice.model.EventType;
import com.qualysoft.devops.seminar.qalevreportservice.repository.AcknowledgerRoleRepository;
import com.qualysoft.devops.seminar.qalevreportservice.repository.EventTypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class EventTypeService {

    @Autowired
    private EventTypeRepository eventTypeRepository;

    @Autowired
    private AcknowledgerRoleRepository acknowledgerRoleRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Returns all the event types in the database.
     *
     * @return Set<EventTypeDto>
     */
    public List<EventTypeDto> getAllEventTypes() {
//        for (EventType eventType : eventTypeRepository.findAll()) {
//            for (AckRole ackRole : eventType.getJurisdiction()) {
//                System.out.println(ackRole.getName());
//            }
//        }

        return StreamSupport
                .stream(eventTypeRepository.findAll().spliterator(), false)
                .map(event -> modelMapper.map(event, EventTypeDto.class))
                .collect(Collectors.toList());

    }

    /**
     * Create event type in the database.
     *
     * @return Set<EventTypeDto>
     */
    public EventTypeDto putEventType(String name, List<AcknowledgerRoleDto> ackRoles) {

        EventType eventType = eventTypeRepository.findByName(name);
        if (eventType == null) {

            boolean allAckRoleExists = true;
            List<AcknowledgerRole> ackRoleEntities = new ArrayList<>();

            for (AcknowledgerRoleDto ackRole : ackRoles) {
                AcknowledgerRole ackRoleEntity = acknowledgerRoleRepository.findByName(ackRole.getName());

                if (ackRoleEntity == null) {
                    allAckRoleExists = false;
                    break;
                } else {
                    ackRoleEntities.add(ackRoleEntity);
                }
            }

            if (allAckRoleExists) {
                eventType = new EventType()
                        .setName(name)
                        .setJurisdiction(ackRoleEntities);

                eventTypeRepository.save(eventType);

                return EventTypeMapper.toEventTypeDto(eventType);
            } else {
                //Not all AckRoles exist
                throw new CustomException.BadRequestException();
            }
        }

        throw new DuplicateEntityException();
    }
}
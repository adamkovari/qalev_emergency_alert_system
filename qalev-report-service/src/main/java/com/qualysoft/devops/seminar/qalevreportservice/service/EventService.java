package com.qualysoft.devops.seminar.qalevreportservice.service;

import com.qualysoft.devops.seminar.qalevreportservice.dto.model.EventDto;
import com.qualysoft.devops.seminar.qalevreportservice.repository.EventRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Returns all the events in the database.
     *
     * @return Set<EventDto>
     */
    public List<EventDto> getAllEvents() {
        return StreamSupport
                .stream(eventRepository.findAll().spliterator(), false)
                .map(event -> modelMapper.map(event, EventDto.class))
                .collect(Collectors.toList());

    }

}
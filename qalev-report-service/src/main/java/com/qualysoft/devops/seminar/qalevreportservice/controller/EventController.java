package com.qualysoft.devops.seminar.qalevreportservice.controller;

import com.qualysoft.devops.seminar.qalevreportservice.dto.model.EventDto;
import com.qualysoft.devops.seminar.qalevreportservice.dto.response.Response;
import com.qualysoft.devops.seminar.qalevreportservice.service.EventService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;
import java.util.Set;

@RestController
@RequestMapping("/api/event")
@Tag(name = "Event")
public class EventController {

    @Autowired
    private EventService eventService;

    /**
     * Returns all the events in the database.
     *
     * @return Set<EventDto>
     */
    @GetMapping
    public Response getAllEvents() {

        return Response
                .ok()
                .setPayload(eventService.getAllEvents());
    }

}
package com.qualysoft.devops.seminar.qalevreportservice.controller;

import com.qualysoft.devops.seminar.qalevreportservice.dto.model.AcknowledgerRoleDto;
import com.qualysoft.devops.seminar.qalevreportservice.dto.response.Response;
import com.qualysoft.devops.seminar.qalevreportservice.dto.model.EventTypeDto;
import com.qualysoft.devops.seminar.qalevreportservice.exception.CustomException;
import com.qualysoft.devops.seminar.qalevreportservice.service.EventTypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/api/event-type")
@Tag(name = "Event Type")
public class EventTypeController {

    @Autowired
    private EventTypeService eventTypeService;

    /**
     * Returns all the EventType in the database.
     *
     * @return List<EventTypeDto>
     */
    @Operation(summary = "Returns all the EventType in the database", responses = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved")
    })
    @GetMapping
    public Response getAllEventTypes() {

        return Response
                .ok()
                .setPayload(eventTypeService.getAllEventTypes());
    }

    /**
     * Creates a new EventType in the database.
     *
     * @return EventTypeDto
     */
    @Operation(summary = "Creates a new EventType in the database",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successfully created"),
                    @ApiResponse(responseCode = "400", description = "EventType.name already exists")
            })
    @PutMapping
    public Response putAckRole(@RequestParam String name, @RequestBody List<AcknowledgerRoleDto> ackRoles) {
        Optional<EventTypeDto> eventTypeDto = Optional.ofNullable(eventTypeService.putEventType(name, ackRoles));
        if (eventTypeDto.isEmpty())
            return Response.validationException();
        else
            return Response.ok().setPayload(eventTypeDto);
    }
}
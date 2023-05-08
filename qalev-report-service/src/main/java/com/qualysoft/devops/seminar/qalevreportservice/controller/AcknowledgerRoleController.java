package com.qualysoft.devops.seminar.qalevreportservice.controller;

import com.qualysoft.devops.seminar.qalevreportservice.dto.model.AcknowledgerRoleDto;
import com.qualysoft.devops.seminar.qalevreportservice.dto.response.Response;
import com.qualysoft.devops.seminar.qalevreportservice.service.AcknowledgerRoleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/ack-role")
@Tag(name = "ACK Role")
public class AcknowledgerRoleController {

    @Autowired
    private AcknowledgerRoleService acknowledgerRoleService;

    /**
     * Returns all the AckRoles in the database.
     *
     * @return Set<AckRoleDto>
     */
    @GetMapping
    public Response getAllAckRoles() {

        return Response
                .ok()
                .setPayload(acknowledgerRoleService.getAllAckRoles());
    }

    /**
     * Creates a new AckRole in the database.
     *
     * @return Set<EventDto>
     */
    @PutMapping
    public Response putAckRole(@RequestParam String name) {
        Optional<AcknowledgerRoleDto> ackRoleDto = Optional.ofNullable(acknowledgerRoleService.putAckRole(name));
        if (ackRoleDto.isEmpty())
            return Response.duplicateEntity();
        else
            return Response.ok().setPayload(ackRoleDto);
    }
}
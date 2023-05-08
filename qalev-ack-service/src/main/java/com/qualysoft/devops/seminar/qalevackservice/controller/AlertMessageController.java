package com.qualysoft.devops.seminar.qalevackservice.controller;

import com.qualysoft.devops.seminar.qalevackservice.dto.response.Response;
import com.qualysoft.devops.seminar.qalevackservice.service.AlertMessageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/alert")
@Tag(name = "Alert")
public class AlertMessageController {

    @Autowired
    private AlertMessageService alertMessageService;

    /**
     * Returns all the AlertMessages in the database.
     *
     * @return List<AlertMessage>
     */
    @GetMapping
    public Response getAllAlertMessages() {

        return Response
                .ok()
                .setPayload(alertMessageService.getAllAlertMessages());
    }
}
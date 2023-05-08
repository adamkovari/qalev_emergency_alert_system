package com.qualysoft.devops.seminar.qalevreportservice.controller;

import com.qualysoft.devops.seminar.qalevreportservice.dto.response.Response;
import com.qualysoft.devops.seminar.qalevreportservice.service.AlertService;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/alert")
@Tag(name = "Alert")
public class AlertController {

    @Autowired
    private AlertService alertService;

    /**
     * Returns all the alerts in the database.
     *
     * @return Set<AlertDto>
     */
    @GetMapping
    public Response getAllAlerts() {

        return Response
                .ok()
                .setPayload(alertService.getAllAlerts());
    }
}
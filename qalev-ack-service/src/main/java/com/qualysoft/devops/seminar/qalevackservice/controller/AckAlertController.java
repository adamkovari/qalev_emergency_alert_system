package com.qualysoft.devops.seminar.qalevackservice.controller;

import com.qualysoft.devops.seminar.qalevackservice.dto.response.Response;
import com.qualysoft.devops.seminar.qalevackservice.model.AlertMessage;
import com.qualysoft.devops.seminar.qalevackservice.service.AlertMessageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ack-alert")
@Tag(name = "ACK Alert")
public class AckAlertController {

    @Autowired
    private AlertMessageService alertMessageService;

    @PostMapping
    public Response acknowledgeAlert(@RequestBody long alertID) {

        AlertMessage alertMessage = alertMessageService.access(alertID);
        if (alertMessage == null) {
            return Response
                    .notFound();
        }

        alertMessageService.acknowledgeAlert(alertMessage);
        return Response
                .ok();
    }
}
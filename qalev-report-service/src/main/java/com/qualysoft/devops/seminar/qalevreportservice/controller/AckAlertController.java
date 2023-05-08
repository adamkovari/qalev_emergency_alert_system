package com.qualysoft.devops.seminar.qalevreportservice.controller;

import com.qualysoft.devops.seminar.qalevreportservice.dto.model.AlertDto;
import com.qualysoft.devops.seminar.qalevreportservice.dto.model.EventDto;
import com.qualysoft.devops.seminar.qalevreportservice.dto.model.EventTypeDto;
import com.qualysoft.devops.seminar.qalevreportservice.dto.response.Response;
import com.qualysoft.devops.seminar.qalevreportservice.model.Ack;
import com.qualysoft.devops.seminar.qalevreportservice.model.EventType;
import com.qualysoft.devops.seminar.qalevreportservice.service.AckAlertService;
import com.qualysoft.devops.seminar.qalevreportservice.service.ReportAlertService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/ack-alert")
@Tag(name = "ACK Alert")
public class AckAlertController {

    @Autowired
    private AckAlertService ackAlertService;

    @PostMapping
    public Response acknowledgeAlert(@RequestBody AlertDto _alertDto) {

        Optional<AlertDto> alertDto = Optional.ofNullable(ackAlertService.acknowledgeAlert(_alertDto));

        if (alertDto.isPresent())
            return Response
                    .ok()
                    .setPayload(alertDto);
        else
            return Response
                    .notFound();
    }
}
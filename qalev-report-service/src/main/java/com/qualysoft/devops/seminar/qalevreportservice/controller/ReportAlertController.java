package com.qualysoft.devops.seminar.qalevreportservice.controller;

import com.qualysoft.devops.seminar.qalevreportservice.dto.model.EventTypeDto;
import com.qualysoft.devops.seminar.qalevreportservice.dto.response.Response;
import com.qualysoft.devops.seminar.qalevreportservice.dto.model.EventDto;
import com.qualysoft.devops.seminar.qalevreportservice.model.EventType;
import com.qualysoft.devops.seminar.qalevreportservice.service.ReportAlertService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/report-alert")
@Tag(name = "Report Alert")
public class ReportAlertController {

    @Autowired
    private ReportAlertService reportAlertService;

    @PostMapping
    public Response reportAlert(@RequestBody EventTypeDto eventType) {
        Optional<EventDto> event = Optional.ofNullable(reportAlertService.report(eventType));
        if (event.isPresent())
            return Response
                    .ok();
        else
            return Response
                    .notFound();
    }
}
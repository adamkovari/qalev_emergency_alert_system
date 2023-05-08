package com.qualysoft.devops.seminar.qalevackservice.controller;

import com.qualysoft.devops.seminar.qalevackservice.dto.model.AlertMessageDto;
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
@RequestMapping("/report-alert")
@Tag(name = "Report Alert")
public class ReportAlertController {

    @Autowired
    private AlertMessageService alertMessageService;

    @PostMapping
    public Response reportAlert(@RequestBody AlertMessageDto alert) {

        alertMessageService.store(alert);

        return Response
                .ok();
    }
}
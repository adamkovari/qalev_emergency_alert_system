package com.qualysoft.devops.seminar.qalevreportservice.dto.mapper;

import com.qualysoft.devops.seminar.qalevreportservice.dto.model.AlertDto;
import com.qualysoft.devops.seminar.qalevreportservice.model.Alert;

public class AlertMapper {

    public static AlertDto toAlertDto(Alert alert) {
        return new AlertDto()
                .setId(alert.getId())
                .setMessage(alert.getMessage());
    }
}
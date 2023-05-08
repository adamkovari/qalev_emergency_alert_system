package com.qualysoft.devops.seminar.qalevackservice.dto.mapper;

import com.qualysoft.devops.seminar.qalevackservice.dto.model.AlertMessageDto;
import com.qualysoft.devops.seminar.qalevackservice.model.AlertMessage;

public class AlertMessageMapper {

    public static AlertMessage toAlertMessage(AlertMessageDto alertMessageDto) {
        return new AlertMessage()
                .setId(alertMessageDto.getId())
                .setMessage(alertMessageDto.getMessage());
    }
}
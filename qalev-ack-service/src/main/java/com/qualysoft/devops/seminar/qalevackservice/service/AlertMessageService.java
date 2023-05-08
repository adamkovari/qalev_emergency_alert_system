package com.qualysoft.devops.seminar.qalevackservice.service;

import com.qualysoft.devops.seminar.qalevackservice.dto.mapper.AlertMessageMapper;
import com.qualysoft.devops.seminar.qalevackservice.dto.model.AlertMessageDto;
import com.qualysoft.devops.seminar.qalevackservice.exception.CustomException;
import com.qualysoft.devops.seminar.qalevackservice.http.HttpHandler;
import com.qualysoft.devops.seminar.qalevackservice.model.AlertMessage;
import com.qualysoft.devops.seminar.qalevackservice.serialize.SerializeAlertMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlertMessageService {

    private Logger logger = LoggerFactory.getLogger(SerializeAlertMessages.class);

    @Autowired
    private SerializeAlertMessages serializeAlertMessages;

    @Autowired
    private HttpHandler httpHandler;

    public List<AlertMessage> getAllAlertMessages() {
        return serializeAlertMessages.getAlerts();
    }

    public void store(AlertMessageDto _alertMessage) {
        AlertMessage alertMessage = AlertMessageMapper.toAlertMessage(_alertMessage);
        serializeAlertMessages.getAlerts().add(alertMessage);
        serializeAlertMessages.write(serializeAlertMessages.getAlerts());
    }

    public AlertMessage access(long alertMessageId) {
        AlertMessage alertMessage = null;
        for (AlertMessage _alertMessage : serializeAlertMessages.getAlerts()) {
            if (_alertMessage.getId() == alertMessageId) {
                alertMessage = _alertMessage;
                break;
            }
        }
        return alertMessage;
    }

    public void acknowledgeAlert(AlertMessage alertMessage) {
        ResponseEntity result = httpHandler.postHttpRequest(alertMessage);
        if (!result.getStatusCode().is2xxSuccessful()) {
            logger.error((String) result.getBody());
            throw new CustomException.Exception(result.getBody().toString());
        }
    }
}
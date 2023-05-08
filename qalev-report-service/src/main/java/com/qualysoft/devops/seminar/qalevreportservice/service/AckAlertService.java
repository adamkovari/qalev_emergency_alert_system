package com.qualysoft.devops.seminar.qalevreportservice.service;

import com.qualysoft.devops.seminar.qalevreportservice.dto.mapper.AlertMapper;
import com.qualysoft.devops.seminar.qalevreportservice.dto.model.AlertDto;
import com.qualysoft.devops.seminar.qalevreportservice.exception.CustomException;
import com.qualysoft.devops.seminar.qalevreportservice.http.HttpHandler;
import com.qualysoft.devops.seminar.qalevreportservice.model.Ack;
import com.qualysoft.devops.seminar.qalevreportservice.model.Alert;
import com.qualysoft.devops.seminar.qalevreportservice.model.Event;
import com.qualysoft.devops.seminar.qalevreportservice.repository.*;
import com.qualysoft.devops.seminar.qalevreportservice.util.Types;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AckAlertService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventTypeRepository eventTypeRepository;

    @Autowired
    private AcknowledgerRepository acknowledgerRepository;

    @Autowired
    private AckRepository ackRepository;

    @Autowired
    private AlertRepository alertRepository;

    @Autowired
    private HttpHandler httpHandler;

    public AlertDto acknowledgeAlert(AlertDto alertDto) {
        Ack ack = new Ack()
                .setAlertId(alertDto.getId());

        ackRepository.save(ack);

        Optional<Alert> alert = alertRepository.findById(ack.getAlertId());
        if (alert.isPresent()) {
            ack.setAlert(alert.get());
            alert.get().setAck(ack);


            boolean closable = true;
            Event event = alert.get().getEvent();
            if (event != null) {
                for (Alert _alert : event.getAlerts()) {
                    if (_alert.getAck() == null) {
                        closable = false;
                        break;
                    }
                }

                if (closable)
                    event.setStatus(Types.EventStatus.CLOSED);
                else
                    event.setStatus(Types.EventStatus.PARTIAL);

                eventRepository.save(event);

                return AlertMapper.toAlertDto(alert.get());
            } else {
                throw new CustomException.EntityNotFoundException();
            }
        }
        throw new CustomException.EntityNotFoundException();

    }
}
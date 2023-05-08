package com.qualysoft.devops.seminar.qalevreportservice.service;

import com.qualysoft.devops.seminar.qalevreportservice.dto.mapper.EventMapper;
import com.qualysoft.devops.seminar.qalevreportservice.dto.model.EventDto;
import com.qualysoft.devops.seminar.qalevreportservice.dto.model.EventTypeDto;
import com.qualysoft.devops.seminar.qalevreportservice.http.HttpHandler;
import com.qualysoft.devops.seminar.qalevreportservice.model.*;
import com.qualysoft.devops.seminar.qalevreportservice.repository.AcknowledgerRepository;
import com.qualysoft.devops.seminar.qalevreportservice.repository.AlertRepository;
import com.qualysoft.devops.seminar.qalevreportservice.repository.EventRepository;
import com.qualysoft.devops.seminar.qalevreportservice.repository.EventTypeRepository;
import com.qualysoft.devops.seminar.qalevreportservice.util.Types;
import com.qualysoft.devops.seminar.qalevreportservice.exception.CustomException.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.qualysoft.devops.seminar.qalevreportservice.dto.mapper.AlertMapper.toAlertDto;
import static com.qualysoft.devops.seminar.qalevreportservice.dto.mapper.EventMapper.toEventDto;

@Component
public class ReportAlertService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventTypeRepository eventTypeRepository;

    @Autowired
    private AcknowledgerRepository acknowledgerRepository;

    @Autowired
    private AlertRepository alertRepository;

    @Autowired
    private HttpHandler httpHandler;


    /**
     * Creates an Event object with status NEW and stores it in db.
     */
    public EventDto report(EventTypeDto _eventType) {

        EventType eventType = eventTypeRepository.findByName(_eventType.getName());
        if (eventType != null) {
            Event event = new Event()
                    .setType(eventType)
                    .setStatus(Types.EventStatus.NEW);

            eventRepository.save(event);

            List<Alert> alerts = new ArrayList<>();
            for (AcknowledgerRole ackRole : eventType.getJurisdiction()) {
                for (Acknowledger ack : ackRole.getAcks()) {
                    Alert alert = new Alert()
                            .setEvent(event);
                    alerts.add(alert);

                    alertRepository.save(alert);
                    httpHandler.postHttpRequest(httpHandler.createURI(ack.getUrl(), ack.getPort(), HttpHandler.EndPoint.REPORT.label), toAlertDto(alert));
                }
            }
            event.setAlerts(alerts);

            System.out.println(event.getAlerts());
            return EventMapper.toEventDto(event);
        }

        throw new EntityNotFoundException();
    }
}
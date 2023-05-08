package com.qualysoft.devops.seminar.qalevreportservice.service;

import com.qualysoft.devops.seminar.qalevreportservice.dto.model.AlertDto;
import com.qualysoft.devops.seminar.qalevreportservice.model.Alert;
import com.qualysoft.devops.seminar.qalevreportservice.repository.AlertRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class AlertService {

    @Autowired
    private AlertRepository alertRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * Returns all the alerts in the database.
     *
     * @return Set<AlertDto>
     */
    public List<Alert> getAllAlerts() {
        return alertRepository.findAll();

    }
}
package com.qualysoft.devops.seminar.qalevreportservice.config;

import com.qualysoft.devops.seminar.qalevreportservice.model.Ack;
import com.qualysoft.devops.seminar.qalevreportservice.model.Acknowledger;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ConfigurationProperties("qalev-report-service")
public class Config {

    private String config;

    private ArrayList<Acknowledger> qalevAckServices;

}
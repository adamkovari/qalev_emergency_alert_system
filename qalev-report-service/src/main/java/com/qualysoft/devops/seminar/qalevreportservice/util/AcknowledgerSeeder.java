package com.qualysoft.devops.seminar.qalevreportservice.util;

import com.qualysoft.devops.seminar.qalevreportservice.config.Config;
import com.qualysoft.devops.seminar.qalevreportservice.repository.AcknowledgerRepository;
import com.qualysoft.devops.seminar.qalevreportservice.repository.AcknowledgerRoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AcknowledgerSeeder {

    @Autowired
    private Config config;

    @Autowired
    private AcknowledgerRoleRepository acknowledgerRoleRepository;

    @Autowired
    private AcknowledgerRepository acknowledgerRepository;

    Logger logger = LoggerFactory.getLogger(AcknowledgerSeeder.class);

    public void createAcknowledgers() {

        acknowledgerRepository.saveAll(config.getQalevAckServices());
        logger.info("Acknowledgers are created from config file");
    }
}
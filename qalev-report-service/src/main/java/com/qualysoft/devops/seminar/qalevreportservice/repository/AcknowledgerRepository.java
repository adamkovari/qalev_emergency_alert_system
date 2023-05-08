package com.qualysoft.devops.seminar.qalevreportservice.repository;

import com.qualysoft.devops.seminar.qalevreportservice.model.Acknowledger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcknowledgerRepository extends JpaRepository<Acknowledger, Long> {

}
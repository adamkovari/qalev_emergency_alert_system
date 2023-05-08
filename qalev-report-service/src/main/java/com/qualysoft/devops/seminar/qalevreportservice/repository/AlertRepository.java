package com.qualysoft.devops.seminar.qalevreportservice.repository;

import com.qualysoft.devops.seminar.qalevreportservice.model.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertRepository extends JpaRepository<Alert, Long> {

}
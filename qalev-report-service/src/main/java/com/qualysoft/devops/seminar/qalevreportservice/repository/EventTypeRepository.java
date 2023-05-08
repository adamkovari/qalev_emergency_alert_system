package com.qualysoft.devops.seminar.qalevreportservice.repository;

import com.qualysoft.devops.seminar.qalevreportservice.model.EventType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventTypeRepository extends JpaRepository<EventType, Long> {

    EventType findByName(String name);
}
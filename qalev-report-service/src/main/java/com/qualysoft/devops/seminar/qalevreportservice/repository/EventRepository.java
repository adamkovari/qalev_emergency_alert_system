package com.qualysoft.devops.seminar.qalevreportservice.repository;

import com.qualysoft.devops.seminar.qalevreportservice.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
    
}
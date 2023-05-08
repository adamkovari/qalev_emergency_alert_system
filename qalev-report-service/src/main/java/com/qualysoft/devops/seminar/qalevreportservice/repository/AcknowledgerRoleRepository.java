package com.qualysoft.devops.seminar.qalevreportservice.repository;

import com.qualysoft.devops.seminar.qalevreportservice.model.AcknowledgerRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcknowledgerRoleRepository extends JpaRepository<AcknowledgerRole, Long> {

    AcknowledgerRole findByName(String name);
}
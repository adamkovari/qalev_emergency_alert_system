package com.qualysoft.devops.seminar.qalevreportservice.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

import com.qualysoft.devops.seminar.qalevreportservice.util.Types;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

//Validation missing

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "eventType")
public class EventType {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    //what ackroles must informed by an alert
    @ManyToMany
    private List<AcknowledgerRole> jurisdiction;
}
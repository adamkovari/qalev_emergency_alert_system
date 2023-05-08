package com.qualysoft.devops.seminar.qalevreportservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.qualysoft.devops.seminar.qalevreportservice.util.Types;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Set;

//Validation missing

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "event")
public class Event {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "eventType_id", referencedColumnName = "id")
    private EventType type;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Types.EventStatus status;

    @JsonManagedReference
    @Column(name = "alerts")
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Alert> alerts;
}
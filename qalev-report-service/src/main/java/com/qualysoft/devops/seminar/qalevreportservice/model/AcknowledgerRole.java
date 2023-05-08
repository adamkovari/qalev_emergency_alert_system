package com.qualysoft.devops.seminar.qalevreportservice.model;

import jakarta.persistence.*;
import com.qualysoft.devops.seminar.qalevreportservice.util.Types;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

//Validation missing


@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "ackRole")
public class AcknowledgerRole {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "role")
    private List<Acknowledger> acks;

}
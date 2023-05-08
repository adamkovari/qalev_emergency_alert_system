package com.qualysoft.devops.seminar.qalevreportservice.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

//Validation missing

//@Data
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
//@ToString(onlyExplicitlyIncluded = true)
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "ackowledger")
public class Acknowledger {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "acknowledgerRole_id", referencedColumnName = "id")
    private AcknowledgerRole role;

    private String url;

    private String port;
}
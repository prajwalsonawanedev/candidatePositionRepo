package com.example.candiatePosition.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "position_tbl",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"position_name"})
        }
)
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long positionId;

    @Column(name = "position_name")
    @JsonProperty("positionName")
    private String name;

    @Column(name = "position_description")
    @JsonProperty("positionDescription")
    private String description;

    @Column(name = "position_location")
    @JsonProperty("positionLocation")
    private String location;

    @Column(name = "position_department")
    @JsonProperty("positionDepartment")
    private String department;

    @Column(name = "position_employement_type")
    @JsonProperty("positionEmployementType")
    private String employementType;

}

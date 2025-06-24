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


    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmployementType() {
        return employementType;
    }

    public void setEmployementType(String employementType) {
        this.employementType = employementType;
    }
}

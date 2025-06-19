package com.example.candiatePosition.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "position_tbl")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long positionId;

    @Column(name = "position_name")
    private String name;

    @Column(name = "position_description")
    private String description;

    @Column(name = "position_location")
    private String location;

    @Column(name = "position_department")
    private String department;

    @Column(name = "position_employement_type")
    private String employementType;

}

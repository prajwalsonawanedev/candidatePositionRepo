package com.example.candiatePosition.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "candidate_tbl")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer candidateId;

}

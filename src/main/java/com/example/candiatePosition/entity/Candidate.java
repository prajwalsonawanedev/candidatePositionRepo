package com.example.candiatePosition.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "candidate_tbl",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"email_id"})
        }
)
@Builder
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long candidateId;

    private String name;

    public String mobileNumber;

    private String age;

    private String city;

    private String emailId;

    private boolean isCandidateExperienced;

    private Integer totalYearsOfExperience;

    private String previousOrganizationName;

    private LocalDate dateOfBirth;

    @ManyToMany
    @JoinTable(
            name = "candidate_position",
            joinColumns = @JoinColumn(name = "candidate_id"),
            inverseJoinColumns = @JoinColumn(name = "position_id")
    )
    private List<Position> positions;


    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public boolean isCandidateExperienced() {
        return isCandidateExperienced;
    }

    public void setCandidateExperienced(boolean candidateExperienced) {
        isCandidateExperienced = candidateExperienced;
    }

    public Integer getTotalYearsOfExperience() {
        return totalYearsOfExperience;
    }

    public void setTotalYearsOfExperience(Integer totalYearsOfExperience) {
        this.totalYearsOfExperience = totalYearsOfExperience;
    }

    public String getPreviousOrganizationName() {
        return previousOrganizationName;
    }

    public void setPreviousOrganizationName(String previousOrganizationName) {
        this.previousOrganizationName = previousOrganizationName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}

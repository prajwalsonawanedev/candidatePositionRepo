package com.example.candiatePosition.dto;

import com.example.candiatePosition.anotation.CheckAge;
import com.example.candiatePosition.anotation.NullOrNotBlank;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public class CandidateRequestDto {

    public Long candidateId;

    @JsonProperty("candidateName")
    @NullOrNotBlank(min = 4, max = 50, message = "Candidate Name required and must be between {min} and {max} characters", isMandatory = "yes")
    public String name;

    @JsonProperty("candidateMobileNumber")
    public String mobileNumber;

    @JsonProperty("candidateEmailId")
    @NullOrNotBlank(isMandatory = "yes")
    public String emailId;

    @JsonProperty("candidateIsExperienced")
    public boolean isCandidateExperienced;

    @JsonProperty("candidatetotalYearsOfExperience")
    public Integer totalYearsOfExperience;

    @JsonProperty("previousOrganizationName")
    public String previousOrganizationName;

    @JsonProperty("candidateAge")
    public Integer age;

    @JsonProperty("candidateCity")
    public String city;

    @JsonProperty("positionIds")
    public List<Long> positionIds;

    @JsonProperty("candidateDateOfBirth")
    @CheckAge
    public LocalDate dateOfBirth;

    public List<Long> positionIds() {
        return positionIds;
    }

    public void setPositionIds(List<Long> positionIds) {
        this.positionIds = positionIds;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

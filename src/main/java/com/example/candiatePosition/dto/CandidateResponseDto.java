package com.example.candiatePosition.dto;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CandidateResponseDto {

    public String name;

    public String mobileNumber;

    public String emailId;

    public boolean isCandidateExperienced;

    public Integer totalYearsOfExperience;

    public String previousOrganizationName;

    public List<Long> positionList;
}

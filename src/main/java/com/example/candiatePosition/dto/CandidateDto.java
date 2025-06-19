package com.example.candiatePosition.dto;

import java.util.List;

public class CandidateDto {

    public Long candidateId;

    public String name;

    public String mobileNumber;

    public String emailId;

    public boolean isCandidateExperienced;

    public Integer totalYearsOfExperience;

    public String previousOrganizationName;

    public List<PositionDto> positionList;
}

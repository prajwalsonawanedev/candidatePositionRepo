package com.example.candiatePosition.dto;

import com.example.candiatePosition.anotation.NullOrNotBlank;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class PositionRequestDto {

    public Long positionId;

    @JsonProperty("positionName")
    @NullOrNotBlank(min = 5, max = 50, message = "Position Name required and must be between {min} and {max} characters", isMandatory = "yes")
    public String name;

    @JsonProperty("positionDescription")
    public String description;

    @JsonProperty("positionLocation")
    public String location;

    @JsonProperty("positionDepartment")
    public String department;

    @JsonProperty("positionEmployementType")
    @JsonAlias("employementType")
    public String employementType;
}

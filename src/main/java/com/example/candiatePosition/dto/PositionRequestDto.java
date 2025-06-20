package com.example.candiatePosition.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
public class PositionRequestDto {

    public Long positionId;

    @JsonProperty("positionName")
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

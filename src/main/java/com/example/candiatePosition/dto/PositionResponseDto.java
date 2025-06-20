package com.example.candiatePosition.dto;

import com.example.candiatePosition.anotation.NullOrNotBlank;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class PositionResponseDto {

    @JsonProperty("positionName")
    @NullOrNotBlank(min = 4, max = 50, message = "Position Name is required and must be between {min} and {max} characters", isMandatory = "yes")
    public String name;

    @JsonProperty("positionDescription")
    public String description;

    @JsonProperty("positionLocation")
    public String location;

    @JsonProperty("positionDepartment")
    public String department;

    @JsonProperty("positionEmployementType")
    public String employementType;
}

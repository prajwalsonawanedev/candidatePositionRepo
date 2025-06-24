package com.example.candiatePosition.service;

import com.example.candiatePosition.dto.PositionRequestDto;
import com.example.candiatePosition.response.ApiResponse;

public interface PositionService {

    ApiResponse savePosition(PositionRequestDto positionDto);

    ApiResponse getPositionById(Long positionId);

    ApiResponse getAllPositions();

    ApiResponse deleteById(Long positionId);

    ApiResponse updatePositionDetails(Long positionId, PositionRequestDto positionDto);


}

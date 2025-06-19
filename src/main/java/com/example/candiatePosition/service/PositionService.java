package com.example.candiatePosition.service;

import com.example.candiatePosition.dto.PositionRequestDto;
import com.example.candiatePosition.dto.PositionResponseDto;

import java.util.List;

public interface PositionService {

    PositionResponseDto savePosition(PositionRequestDto positionDto);

    PositionResponseDto getPositionById(Long positionId);

    List<PositionResponseDto> getAllPositions();
}

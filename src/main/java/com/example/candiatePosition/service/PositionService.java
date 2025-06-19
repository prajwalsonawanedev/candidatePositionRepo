package com.example.candiatePosition.service;

import com.example.candiatePosition.dto.PositionDto;

import java.util.List;

public interface PositionService {

    PositionDto savePosition(PositionDto positionDto);

    PositionDto getPositionById(Long positionId);

    List<PositionDto> getAllPositions();
}

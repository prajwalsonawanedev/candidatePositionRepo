package com.example.candiatePosition.serviceImpl;

import com.example.candiatePosition.dto.PositionDto;
import com.example.candiatePosition.service.PositionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Override
    public PositionDto savePosition(PositionDto positionDto) {
        return null;
    }

    @Override
    public PositionDto getPositionById(Long positionId) {
        return null;
    }

    @Override
    public List<PositionDto> getAllPositions() {
        return List.of();
    }
}

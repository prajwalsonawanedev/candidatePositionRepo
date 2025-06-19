package com.example.candiatePosition.serviceImpl;

import com.example.candiatePosition.dto.PositionRequestDto;
import com.example.candiatePosition.dto.PositionResponseDto;
import com.example.candiatePosition.entity.Position;
import com.example.candiatePosition.exception.ResourceNotFoundException;
import com.example.candiatePosition.repository.PositionRepository;
import com.example.candiatePosition.service.PositionService;
import com.example.candiatePosition.util.EntityDtoConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;

    private final EntityDtoConverter entityDtoConverter;

    public PositionServiceImpl(PositionRepository positionRepository, EntityDtoConverter entityDtoConverter) {
        this.positionRepository = positionRepository;
        this.entityDtoConverter = entityDtoConverter;
    }

    @Override
    public PositionResponseDto savePosition(PositionRequestDto positionDto) {
        Position position = entityDtoConverter.convert(positionDto, Position.class);
        if (!ObjectUtils.isEmpty(position)) {
            return entityDtoConverter.convert(positionRepository.save(position), PositionResponseDto.class);
        }
        return null;
    }

    @Override
    public PositionResponseDto getPositionById(Long positionId) {
        return positionRepository.findById(positionId)
                .map(position -> entityDtoConverter.convert(position, PositionResponseDto.class))
                .orElseThrow(() -> new ResourceNotFoundException("Position Not found with Position Id :" + positionId));
    }

    @Override
    public List<PositionResponseDto> getAllPositions() {
        return positionRepository.findAll()
                .stream()
                .map(position -> entityDtoConverter.convert(position, PositionResponseDto.class))
                .map(position -> entityDtoConverter.convert(position, PositionResponseDto.class))
                .toList();
    }
}

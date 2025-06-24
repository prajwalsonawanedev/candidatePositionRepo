package com.example.candiatePosition.serviceImpl;

import com.example.candiatePosition.dto.PositionRequestDto;
import com.example.candiatePosition.dto.PositionResponseDto;
import com.example.candiatePosition.entity.Position;
import com.example.candiatePosition.exception.ResourceNotFoundException;
import com.example.candiatePosition.mapper.PosititonMapper;
import com.example.candiatePosition.repository.PositionRepository;
import com.example.candiatePosition.response.ApiResponse;
import com.example.candiatePosition.service.PositionService;
import com.example.candiatePosition.util.EntityDtoConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

@Service
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;

    private final EntityDtoConverter entityDtoConverter;

    private final PosititonMapper posititonMapper;

    public PositionServiceImpl(PositionRepository positionRepository, EntityDtoConverter entityDtoConverter, PosititonMapper posititonMapper) {
        this.positionRepository = positionRepository;
        this.entityDtoConverter = entityDtoConverter;
        this.posititonMapper = posititonMapper;
    }

    @Override
    public ApiResponse savePosition(PositionRequestDto positionRequestDto) {
        Position position = posititonMapper.toEntity(positionRequestDto);

        if (!ObjectUtils.isEmpty(position)) {
            try {
                PositionResponseDto positionResponseDto = posititonMapper.fromEntity(positionRepository.save(position));
                return ApiResponse.response("Position Created Successfully", true, positionResponseDto);
            } catch (Exception exception) {
                throw new RuntimeException("Please Provide Valid position name");
            }
        }
        return ApiResponse.response("Unable to crate position", false, null);
    }

    @Override
    public ApiResponse getPositionById(Long positionId) {
        PositionResponseDto positionResponseDto = positionRepository.findById(positionId)
                .map(position -> posititonMapper.fromEntity(position))
                .orElseThrow(() -> new ResourceNotFoundException("Position Not found with Position Id :" + positionId));

        if (!Objects.isNull(positionResponseDto)) {
            return ApiResponse.response("Position Details found", true, positionResponseDto);
        }
        return ApiResponse.response("Position Details Not found", true, null);
    }

    @Override
    public ApiResponse getAllPositions() {
        List<PositionResponseDto> positionResponseDtoList = positionRepository.findAll()
                .stream()
                .map(position -> posititonMapper.fromEntity(position))
                .toList();

        if (!CollectionUtils.isEmpty(positionResponseDtoList)) {
            return ApiResponse.response("Position Detailsfound", true, positionResponseDtoList);
        }

        return ApiResponse.response("Position Details Not found", false, null);
    }

    @Override
    public ApiResponse deleteById(Long positionId) {
        try {
            positionRepository.deleteById(positionId);
        } catch (Exception exception) {
            throw new ResourceNotFoundException("Please provide valid position Id:" + positionId);
        }
        return ApiResponse.response("Succesully deleted record with Id:" + positionId, true, null);

    }

    @Override
    public ApiResponse updatePositionDetails(Long positionId, PositionRequestDto positionDto) {

        if (!Objects.isNull(positionDto)) {

            Position positionResult = positionRepository.findById(positionId)
                    .orElseThrow(() -> new ResourceNotFoundException("Position Details not found for this position Id : " + positionId));

            if (!StringUtils.isEmpty(positionDto.name)) {
                positionResult.setName(positionDto.name);
            }
            if (!StringUtils.isEmpty(positionDto.description)) {
                positionResult.setDescription(positionDto.description);
            }
            if (!StringUtils.isEmpty(positionDto.location)) {
                positionResult.setLocation(positionDto.location);
            }
            if (!StringUtils.isEmpty(positionDto.department)) {
                positionResult.setDepartment(positionDto.department);
            }
            if (!StringUtils.isEmpty(positionDto.employementType)) {
                positionResult.setEmployementType(positionDto.employementType);
            }

            Position updatedPosition = positionRepository.save(positionResult);
            return ApiResponse.response("Position details updated Sucessfully", true, updatedPosition);

        }
        return ApiResponse.response("Please provide valid postion details", false, null);

    }
}

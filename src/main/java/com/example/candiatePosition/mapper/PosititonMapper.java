package com.example.candiatePosition.mapper;

import com.example.candiatePosition.dto.PositionRequestDto;
import com.example.candiatePosition.entity.Position;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PosititonMapper {

    PositionRequestDto toDto(Position position);

    Position toEntity(PositionRequestDto positionRequestDto);
}


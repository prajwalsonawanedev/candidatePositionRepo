package com.example.candiatePosition.mapper;

import com.example.candiatePosition.dto.PositionRequestDto;
import com.example.candiatePosition.dto.PositionResponseDto;
import com.example.candiatePosition.entity.Position;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PosititonMapper {


    PosititonMapper mapper = Mappers.getMapper(PosititonMapper.class);

    Position toEntity(PositionRequestDto positionRequestDto);

    PositionResponseDto fromEntity(Position position);
}


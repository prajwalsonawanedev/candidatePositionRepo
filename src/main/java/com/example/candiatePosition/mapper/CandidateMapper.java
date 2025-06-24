package com.example.candiatePosition.mapper;

import com.example.candiatePosition.dto.CandidateRequestDto;
import com.example.candiatePosition.dto.CandidateResponseDto;
import com.example.candiatePosition.entity.Candidate;
import com.example.candiatePosition.entity.Position;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CandidateMapper {

    CandidateMapper mapper = Mappers.getMapper(CandidateMapper.class);

    @Mapping(source = "positionIds", target = "positions", qualifiedByName = "idsToPositions")
    Candidate toEntity(CandidateRequestDto candidateRequestDto);

    @Mapping(source = "positions", target = "positionList", qualifiedByName = "positionsToIds")
    CandidateResponseDto fromEntity(Candidate candidate);

    @Named("positionsToIds")
    default List<Long> positionsToIds(List<Position> positions) {
        if (!CollectionUtils.isEmpty(positions)) {
            return positions
                    .stream()
                    .map(Position::getPositionId)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @Named("idsToPositions")
    default List<Position> idsToPositions(List<Long> ids) {
        if (!CollectionUtils.isEmpty(ids)) {
            return ids
                    .stream()
                    .map(id -> {
                        Position pos = new Position();
                        pos.setPositionId(id);
                        return pos;
                    }).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}

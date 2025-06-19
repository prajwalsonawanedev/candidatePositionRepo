package com.example.candiatePosition.serviceImpl;

import com.example.candiatePosition.dto.CandidateRequestDto;
import com.example.candiatePosition.dto.CandidateResponseDto;
import com.example.candiatePosition.dto.PositionRequestDto;
import com.example.candiatePosition.entity.Candidate;
import com.example.candiatePosition.entity.Position;
import com.example.candiatePosition.exception.ResourceNotFoundException;
import com.example.candiatePosition.repository.CandidateRepository;
import com.example.candiatePosition.repository.PositionRepository;
import com.example.candiatePosition.service.CandidateService;
import com.example.candiatePosition.util.EntityDtoConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandiateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;
    private final EntityDtoConverter entityDtoConverter;
    private final PositionRepository positionRepository;

    public CandiateServiceImpl(CandidateRepository candidateRepository, EntityDtoConverter entityDtoConverter, PositionRepository positionRepository) {
        this.candidateRepository = candidateRepository;
        this.entityDtoConverter = entityDtoConverter;
        this.positionRepository = positionRepository;
    }


    @Override
    public CandidateResponseDto saveCandidate(CandidateRequestDto candidateDto) {

        List<Long> requestPositionList = candidateDto.positionIds();

        List<Long> existingIds = positionRepository.findExistingPositionIds(requestPositionList);

        List<Long> missingIds = requestPositionList.stream()
                .filter(id -> !existingIds.contains(id))
                .collect(Collectors.toList());

        if (!missingIds.isEmpty()) {
            throw new ResourceNotFoundException("These Position IDs not found: " + missingIds);
        }
        List<Position> positions = positionRepository.findAllById(requestPositionList);

        Candidate candidate = entityDtoConverter.convert(candidateDto, Candidate.class);

        candidate.setPositions(positions);

        Candidate candidateResult = candidateRepository.save(candidate);

        if (!ObjectUtils.isEmpty(candidateResult)) {
            return entityDtoConverter.convert(candidateResult, CandidateResponseDto.class);
        }
        return null;
    }

    @Override
    public CandidateResponseDto getCandidateById(Long candidateId) {
        return candidateRepository.findById(candidateId)
                .map(candidate -> entityDtoConverter.convert(candidate, CandidateResponseDto.class))
                .orElseThrow(() -> new ResourceNotFoundException("Candidate Details Not found with Id :" + candidateId));
    }

    @Override
    public List<CandidateResponseDto> getAllCandiates() {
        return candidateRepository.findAll()
                .stream()
                .map(candidate -> entityDtoConverter.convert(candidate, CandidateResponseDto.class))
                .toList();
    }
}

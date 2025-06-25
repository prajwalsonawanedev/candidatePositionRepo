package com.example.candiatePosition.serviceImpl;

import com.example.candiatePosition.dto.CandidateRequestDto;
import com.example.candiatePosition.dto.CandidateResponseDto;
import com.example.candiatePosition.entity.Candidate;
import com.example.candiatePosition.entity.Position;
import com.example.candiatePosition.exception.ResourceNotFoundException;
import com.example.candiatePosition.mapper.CandidateMapper;
import com.example.candiatePosition.repository.CandidateRepository;
import com.example.candiatePosition.repository.PositionRepository;
import com.example.candiatePosition.response.ApiResponse;
import com.example.candiatePosition.service.CandidateService;
import com.example.candiatePosition.util.EntityDtoConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CandiateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;
    private final EntityDtoConverter entityDtoConverter;
    private final PositionRepository positionRepository;
    private final CandidateMapper candidateMapper;

    public CandiateServiceImpl(CandidateRepository candidateRepository, EntityDtoConverter entityDtoConverter, PositionRepository positionRepository, CandidateMapper candidateMapper) {
        this.candidateRepository = candidateRepository;
        this.entityDtoConverter = entityDtoConverter;
        this.positionRepository = positionRepository;
        this.candidateMapper = candidateMapper;
    }


    @Override
    public ApiResponse saveCandidate(CandidateRequestDto candidateDto) {

        if (!CollectionUtils.isEmpty(candidateDto.positionIds())) {

            List<Long> existingIds = positionRepository.findExistingPositionIds(candidateDto.positionIds());

            List<Long> missingIds = candidateDto.positionIds.stream().filter(id -> !existingIds.contains(id)).collect(Collectors.toList());

            if (!missingIds.isEmpty()) {
                log.info("Provided position ids are not present");
                throw new ResourceNotFoundException("These Position IDs not found: " + missingIds);
            }
            List<Position> positions = positionRepository.findAllById(candidateDto.positionIds);

            Candidate candidate = candidateMapper.toEntity(candidateDto);

            candidate.setPositions(positions);

            Candidate candidateResult = candidateRepository.save(candidate);

            if (!ObjectUtils.isEmpty(candidateResult)) {
                log.info("Candidate Data saved Successfully: {}", candidateResult);
                return ApiResponse.response("Candidate Details Saved Successfully", true, candidateResult);
            }
        }

        log.info("Candidate Data is invalid: {}", candidateDto);
        return ApiResponse.response("Unable to save Candidate Details", true, null);
    }

    @Override
    public ApiResponse<CandidateResponseDto> getCandidateById(Long candidateId) {

        CandidateResponseDto candidateResponseDto = candidateRepository.findById(candidateId)
                .map(candidate -> candidateMapper.fromEntity(candidate))
                .orElseThrow(() -> new ResourceNotFoundException("Candidate Details Not found with Id :" + candidateId));

        if (!ObjectUtils.isEmpty(candidateResponseDto)) {
            log.info("Candiadate Details Found : {}", candidateResponseDto);
            return ApiResponse.response("Candidate Details Found", true, candidateResponseDto);
        }

        log.info("Candiadate Details Not Found : {}", candidateResponseDto);
        return ApiResponse.response("Candidate Details Not Found", false, candidateResponseDto);
    }

    @Override
    public ApiResponse getAllCandiates() {

        List<CandidateResponseDto> candidateResponseDtoList = candidateRepository.findAll()
                .stream()
                .map(candidate -> candidateMapper.fromEntity(candidate)).toList();


        if (!CollectionUtils.isEmpty(candidateResponseDtoList)) {
            log.info("Candiadate Details Found : {}", candidateResponseDtoList);
            return ApiResponse.response("Candidate Details Found", true, candidateResponseDtoList);
        }

        log.info("Candiadate Details Not Found : {}", candidateResponseDtoList);
        return ApiResponse.response("Candidate Details Not Found", true, candidateResponseDtoList);
    }

    @Override
    public ApiResponse updateCandidateDetails(Long candidateId, CandidateRequestDto candidateRequestDto) {
        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new ResourceNotFoundException("Candidate Details not found for this Id :" + candidateId));

        log.info("Candidate Details Found in database :{}", candidate);
        if (!Objects.isNull(candidateRequestDto)) {

            if (!StringUtils.isEmpty(candidateRequestDto.name)) {
                candidate.setName(candidateRequestDto.getName());
            }
            if (!StringUtils.isEmpty(candidateRequestDto.mobileNumber)) {
                candidate.setMobileNumber(candidateRequestDto.getMobileNumber());
            }
            if (!StringUtils.isEmpty(candidateRequestDto.age)) {
                candidate.setAge(candidateRequestDto.getAge().toString());
            }
            if (!StringUtils.isEmpty(candidateRequestDto.city)) {
                candidate.setCity(candidateRequestDto.getCity());
            }
            if (!StringUtils.isEmpty(candidateRequestDto.emailId)) {
                candidate.setEmailId(candidateRequestDto.getEmailId());
            }
            if (!StringUtils.isEmpty(candidateRequestDto.previousOrganizationName)) {
                candidate.setPreviousOrganizationName(candidateRequestDto.getPreviousOrganizationName());
            }
            if (!Objects.isNull(candidateRequestDto.getTotalYearsOfExperience())) {
                candidate.setTotalYearsOfExperience(candidateRequestDto.getTotalYearsOfExperience());
            }
            if (!Objects.isNull(candidateRequestDto.isCandidateExperienced)) {
                candidate.setCandidateExperienced(candidateRequestDto.isCandidateExperienced);
            }

            Candidate updatedCandidate = candidateRepository.save(candidate);
            log.info("Candiate Details update Successfully :{}", updatedCandidate);
            return ApiResponse.response("Candidate Details Update Sucessfully ", true, candidateMapper.fromEntity(updatedCandidate));
        }
        return ApiResponse.response("Please provide valid candidate details", false, null);

    }

    @Override
    public ApiResponse deleteCandidateByid(Long candidateId) {

        try {
            candidateRepository.deleteById(candidateId);
        } catch (Exception exception) {
            throw new ResourceNotFoundException("Please provide valid candidate Id :" + candidateId);
        }
        log.info("Candiate Details update Successfully");
        return ApiResponse.response("Candidate Details Deleted sucessfully :" + candidateId, true, null);
    }
}

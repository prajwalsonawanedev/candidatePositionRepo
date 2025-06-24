package com.example.candiatePosition.service;

import com.example.candiatePosition.dto.CandidateRequestDto;
import com.example.candiatePosition.dto.CandidateResponseDto;
import com.example.candiatePosition.response.ApiResponse;

public interface CandidateService {

    ApiResponse saveCandidate(CandidateRequestDto candidateDto);

    ApiResponse<CandidateResponseDto> getCandidateById(Long candidateId);

    ApiResponse getAllCandiates();

    ApiResponse updateCandidateDetails(Long candidateId, CandidateRequestDto candidateRequestDto);

    ApiResponse deleteCandidateByid(Long candidateId);

}

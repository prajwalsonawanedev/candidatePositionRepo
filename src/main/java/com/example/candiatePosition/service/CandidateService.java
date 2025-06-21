package com.example.candiatePosition.service;

import com.example.candiatePosition.dto.CandidateRequestDto;
import com.example.candiatePosition.response.ApiResponse;

import java.util.List;

public interface CandidateService {

    ApiResponse saveCandidate(CandidateRequestDto candidateDto);

    ApiResponse getCandidateById(Long candidateId);

    ApiResponse getAllCandiates();

    ApiResponse updateCandidateDetails(Long candidateId, CandidateRequestDto candidateRequestDto);

    ApiResponse deleteCandidateByid(Long candidateId);

}

package com.example.candiatePosition.service;

import com.example.candiatePosition.dto.CandidateRequestDto;
import com.example.candiatePosition.dto.CandidateResponseDto;

import java.util.List;

public interface CandidateService {

    CandidateResponseDto saveCandidate(CandidateRequestDto candidateDto);

    CandidateResponseDto getCandidateById(Long candidateId);

    List<CandidateResponseDto> getAllCandiates();

}

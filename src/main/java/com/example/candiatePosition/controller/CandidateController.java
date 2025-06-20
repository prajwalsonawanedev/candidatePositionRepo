package com.example.candiatePosition.controller;

import com.example.candiatePosition.dto.CandidateRequestDto;
import com.example.candiatePosition.dto.CandidateResponseDto;
import com.example.candiatePosition.response.ApiResponse;
import com.example.candiatePosition.service.CandidateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CandidateController {

    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping("/saveCandidateDetails")
    public ResponseEntity<ApiResponse> saveCandidateDetails(@RequestBody CandidateRequestDto candidateRequestDto) {
        CandidateResponseDto candidateResponseDto = candidateService.saveCandidate(candidateRequestDto);
        return new ResponseEntity<>(ApiResponse.response("Candidate Details saved Successfully",
                true, candidateResponseDto), HttpStatus.OK);

    }

    @GetMapping("/getCandidateDetailsById")
    public ResponseEntity<ApiResponse> getCandidateDetails(@RequestParam Long candidateId) {
        CandidateResponseDto candidateResponseDto = candidateService.getCandidateById(candidateId);

        if (!ObjectUtils.isEmpty(candidateResponseDto)) {
            return new ResponseEntity<>(ApiResponse.response("Candiadte Details found with id :" + candidateId,
                    true, candidateResponseDto), HttpStatus.OK);
        }
        return new ResponseEntity<>(ApiResponse.response("Candidate Details not found with Id :" + candidateId,
                false, null), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAllCandidateDetails")
    public ResponseEntity<ApiResponse> getAllCandidateDetails() {
        List<CandidateResponseDto> candidateResponseDtoList = candidateService.getAllCandiates();

        if (!CollectionUtils.isEmpty(candidateResponseDtoList)) {
            return new ResponseEntity<>(ApiResponse.response("Candidate Details found", true, candidateResponseDtoList), HttpStatus.OK);
        }
        return new ResponseEntity<>(ApiResponse.response("Candidate Details Not Found", false, null), HttpStatus.NOT_FOUND);
    }

}

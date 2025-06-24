package com.example.candiatePosition.controller;

import com.example.candiatePosition.dto.CandidateRequestDto;
import com.example.candiatePosition.dto.CandidateResponseDto;
import com.example.candiatePosition.response.ApiResponse;
import com.example.candiatePosition.service.CandidateService;
import com.example.candiatePosition.util.ObjectConverter;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CandidateController {

    private final CandidateService candidateService;

    private final ObjectConverter objectConverter;

    public CandidateController(CandidateService candidateService, ObjectConverter objectConverter) {
        this.candidateService = candidateService;
        this.objectConverter = objectConverter;
    }

    @PostMapping("/saveCandidateDetails")
    public ResponseEntity<ApiResponse> saveCandidateDetails(@RequestBody @Valid CandidateRequestDto candidateRequestDto) {
        return new ResponseEntity<>(candidateService.saveCandidate(candidateRequestDto), HttpStatus.OK);
    }

    @GetMapping(value = "/getCandidateDetailsById", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<CandidateResponseDto>> getCandidateDetails(@RequestParam Long candidateId) {
        return new ResponseEntity<>(candidateService.getCandidateById(candidateId), HttpStatus.OK);
    }

    @GetMapping("/getAllCandidateDetails")
    public ResponseEntity<ApiResponse> getAllCandidateDetails() {
        return new ResponseEntity<>(candidateService.getAllCandiates(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteCandidateDetails")
    public ResponseEntity<ApiResponse> deleteCandidateDetails(@RequestParam Long candidateId) {
        return new ResponseEntity<>(candidateService.deleteCandidateByid(candidateId), HttpStatus.OK);
    }

    @PatchMapping("/updateCandidateDetails")
    public ResponseEntity<ApiResponse> updateCandidateDetails(@RequestParam Long candidateId, @RequestBody String payload) {
        CandidateRequestDto candidateRequestDto = objectConverter.convertToObject(payload, CandidateRequestDto.class);

        ApiResponse apiResponse = candidateService.updateCandidateDetails(candidateId, candidateRequestDto);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}

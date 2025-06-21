package com.example.candiatePosition.controller;

import com.example.candiatePosition.dto.CandidateRequestDto;
import com.example.candiatePosition.response.ApiResponse;
import com.example.candiatePosition.service.CandidateService;
import com.example.candiatePosition.util.ObjectConverter;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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
        ApiResponse apiResponse = candidateService.saveCandidate(candidateRequestDto);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/getCandidateDetailsById")
    public ResponseEntity<ApiResponse> getCandidateDetails(@RequestParam Long candidateId) {
        ApiResponse apiResponse = candidateService.getCandidateById(candidateId);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/getAllCandidateDetails")
    public ResponseEntity<ApiResponse> getAllCandidateDetails() {
        ApiResponse apiResponse = candidateService.getAllCandiates();
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteCandidateDetails")
    public ResponseEntity<ApiResponse> deleteCandidateDetails(@RequestParam Long candidateId) {
        ApiResponse apiResponse = candidateService.deleteCandidateByid(candidateId);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PatchMapping("/updateCandidateDetails")
    public ResponseEntity<ApiResponse> updateCandidateDetails(@RequestParam Long candidateId, @RequestBody String payload) {
        CandidateRequestDto candidateRequestDto = objectConverter.convertToObject(payload, CandidateRequestDto.class);

        ApiResponse apiResponse = candidateService.updateCandidateDetails(candidateId, candidateRequestDto);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}

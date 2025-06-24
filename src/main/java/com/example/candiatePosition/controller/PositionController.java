package com.example.candiatePosition.controller;

import com.example.candiatePosition.dto.PositionRequestDto;
import com.example.candiatePosition.response.ApiResponse;
import com.example.candiatePosition.service.PositionService;
import com.example.candiatePosition.util.ObjectConverter;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PositionController {

    private final PositionService positionService;

    private final ObjectConverter objectConverter;


    public PositionController(PositionService positionService, ObjectConverter objectConverter) {
        this.positionService = positionService;
        this.objectConverter = objectConverter;
    }

    @PostMapping("/savePosition")
    public ResponseEntity<ApiResponse> savePosition(@RequestBody @Valid PositionRequestDto positionDto) {
        ApiResponse apiResponse = positionService.savePosition(positionDto);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/getPositionById")
    public ResponseEntity<ApiResponse> getPositionById(@RequestParam Long positionId) {
        ApiResponse apiResponse = positionService.getPositionById(positionId);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/getAllPositions")
    public ResponseEntity<ApiResponse> getAllPositions() {
        ApiResponse apiResponse = positionService.getAllPositions();
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<ApiResponse> deleteById(@RequestParam Long postionId) {
        ApiResponse apiResponse = positionService.deleteById(postionId);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PatchMapping("/updatePositionDetails")
    public ResponseEntity<ApiResponse> updatePositionDetails(@RequestParam Long positionId, @RequestBody String payload) {
        PositionRequestDto positionRequestDto = objectConverter.convertToObject(payload, PositionRequestDto.class);
        ApiResponse apiResponse = positionService.updatePositionDetails(positionId, positionRequestDto);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}

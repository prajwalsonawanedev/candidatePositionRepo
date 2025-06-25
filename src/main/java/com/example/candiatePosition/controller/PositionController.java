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
        return new ResponseEntity<>(positionService.savePosition(positionDto), HttpStatus.OK);
    }

    @GetMapping("/getPositionById")
    public ResponseEntity<ApiResponse> getPositionById(@RequestParam Long positionId) {
        return new ResponseEntity<>(positionService.getPositionById(positionId), HttpStatus.OK);
    }

    @GetMapping("/getAllPositions")
    public ResponseEntity<ApiResponse> getAllPositions() {
        return new ResponseEntity<>(positionService.getAllPositions(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<ApiResponse> deleteById(@RequestParam Long postionId) {
        return new ResponseEntity<>(positionService.deleteById(postionId), HttpStatus.OK);
    }

    @PatchMapping("/updatePositionDetails")
    public ResponseEntity<ApiResponse> updatePositionDetails(@RequestParam Long positionId, @RequestBody String payload) {
        PositionRequestDto positionRequestDto = objectConverter.convertToObject(payload, PositionRequestDto.class);
        return new ResponseEntity<>(positionService.updatePositionDetails(positionId, positionRequestDto), HttpStatus.OK);
    }
}

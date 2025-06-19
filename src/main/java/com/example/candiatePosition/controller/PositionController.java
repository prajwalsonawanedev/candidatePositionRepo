package com.example.candiatePosition.controller;

import com.example.candiatePosition.dto.PositionRequestDto;
import com.example.candiatePosition.dto.PositionResponseDto;
import com.example.candiatePosition.response.ApiResponse;
import com.example.candiatePosition.service.PositionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PositionController {

    private final PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }


    @PostMapping("/savePosition")
    public ResponseEntity<ApiResponse> savePosition(@RequestBody PositionRequestDto positionDto) {
        ApiResponse apiResponse = null;
        PositionResponseDto result = positionService.savePosition(positionDto);
        if (!ObjectUtils.isEmpty(result)) {
            apiResponse = ApiResponse.response("Position Created Successfully", true, result);
        }
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);

    }

    @GetMapping("/getPositionById")
    public ResponseEntity<ApiResponse> getPositionById(@RequestParam Long positionId) {
        PositionResponseDto positionResult = positionService.getPositionById(positionId);
        ApiResponse apiResponse = ApiResponse.response("Position found", true, positionResult);

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/getAllPositions")
    public ResponseEntity<ApiResponse> getAllPositions() {
        ApiResponse apiResponse = null;
        List<PositionResponseDto> positionDtoList = positionService.getAllPositions();

        if (!CollectionUtils.isEmpty(positionDtoList)) {
            apiResponse = ApiResponse.response("Position found", true, positionDtoList);
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

}

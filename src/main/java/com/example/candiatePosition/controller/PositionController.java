package com.example.candiatePosition.controller;

import com.example.candiatePosition.dto.PositionDto;
import com.example.candiatePosition.service.PositionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PositionController {

    private final PositionService positionService;

    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }


    @PostMapping("/savePosition")
    public PositionDto savePosition(@RequestBody PositionDto positionDto) {
    

    }
}

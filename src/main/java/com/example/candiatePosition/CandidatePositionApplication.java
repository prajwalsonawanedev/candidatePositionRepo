package com.example.candiatePosition;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class CandidatePositionApplication {

    public static void main(String[] args) {
        SpringApplication.run(CandidatePositionApplication.class, args);
        log.info("Application Started Successfully");
    }

}

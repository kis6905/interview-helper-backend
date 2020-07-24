package com.develeaf.interviewer.finishedinterview.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.develeaf.interviewer.common.dto.CommonDto;

@RestController("/finishedinterview")
public class FinishedInterviewController {
	
	@GetMapping("/list")
	public ResponseEntity<CommonDto> getFinishedInterviewList() {
		
		return ResponseEntity.ok(new CommonDto());
	}
	
}

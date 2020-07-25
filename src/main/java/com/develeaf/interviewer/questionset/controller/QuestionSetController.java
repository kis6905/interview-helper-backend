package com.develeaf.interviewer.questionset.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.develeaf.interviewer.common.dto.CommonDto;

@RestController("/question/set")
public class QuestionSetController {
	
	@GetMapping("/list")
	public ResponseEntity<CommonDto> getQuestionSetList() {
		
		return ResponseEntity.ok(new CommonDto());
	}
	
}

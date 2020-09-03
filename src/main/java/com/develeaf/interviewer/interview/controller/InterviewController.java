package com.develeaf.interviewer.interview.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.develeaf.interviewer.common.view.Response;

@RestController("/interview")
public class InterviewController {
	
	@GetMapping("/list/")
	public Response<?> getQuestionSetList(@PathVariable(name = "companySeq", required = true) Long companySeq) {
		// TODO: 해야함
		return Response.createSuccess();
	}
	
}

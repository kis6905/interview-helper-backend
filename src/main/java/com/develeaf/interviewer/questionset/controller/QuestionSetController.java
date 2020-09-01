package com.develeaf.interviewer.questionset.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.develeaf.interviewer.common.view.Response;
import com.develeaf.interviewer.questionset.dto.QuestionSetDto;
import com.develeaf.interviewer.questionset.service.QuestionSetService;

@RestController
@RequestMapping("/question/set")
public class QuestionSetController {
	
	@Autowired
	private QuestionSetService questionSetService;
	
	@GetMapping("/list/{companySeq}")
	public Response<List<QuestionSetDto>> getQuestionSetList(@PathVariable(name = "companySeq", required = true) Long companySeq) {
		List<QuestionSetDto> quesetionSetList = questionSetService.getQuestionSetList(companySeq);
		return Response.createSuccess(quesetionSetList);
	}
	
	@PostMapping("/{companySeq}")
	public Response<QuestionSetDto> postQuestSet(@RequestBody QuestionSetDto questionSetDto) {
		QuestionSetDto dto = questionSetService.registQuestionSet(questionSetDto);
		return Response.createSuccess(dto);
	}
	
}

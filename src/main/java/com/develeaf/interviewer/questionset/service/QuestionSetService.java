package com.develeaf.interviewer.questionset.service;

import java.util.List;

import com.develeaf.interviewer.questionset.dto.QuestionSetDto;

public interface QuestionSetService {
	
	List<QuestionSetDto> getQuestionSetList(Long companySeq);
	
}

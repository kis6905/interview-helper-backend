package com.develeaf.interviewer.questionset.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.develeaf.interviewer.questionset.dto.QuestionSetDto;
import com.develeaf.interviewer.questionset.entity.QuestionSetEntity;
import com.develeaf.interviewer.questionset.repository.QuestionSetRepository;
import com.develeaf.interviewer.questionset.service.QuestionSetService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("QuestionSetService")
public class QuestionSetServiceImpl implements QuestionSetService {
	
	@Autowired
	private QuestionSetRepository questionSetRepository;
	
	@Override
	public List<QuestionSetDto> getQuestionSetList(Long companySeq) {
		List<Long> ids = new ArrayList<Long>();
		ids.add(companySeq);
		List<QuestionSetEntity> list = questionSetRepository.findAllById(ids);
		
		log.info("list: {}", list);
		
		// TODO: convert dto
		
		return null;
	}

}

package com.develeaf.interviewer.questionset.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.develeaf.interviewer.common.utils.DateUtil;
import com.develeaf.interviewer.company.entity.CompanyEntity;
import com.develeaf.interviewer.company.repository.CompanyRepository;
import com.develeaf.interviewer.questionset.dto.QuestionSetDto;
import com.develeaf.interviewer.questionset.entity.QuestionSetEntity;
import com.develeaf.interviewer.questionset.repository.QuestionSetRepository;
import com.develeaf.interviewer.questionset.service.QuestionSetService;

@Service("QuestionSetService")
public class QuestionSetServiceImpl implements QuestionSetService {
	
	@Autowired
	private QuestionSetRepository questionSetRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<QuestionSetDto> getQuestionSetList(Long companySeq) {
		List<QuestionSetEntity> list = questionSetRepository.findAllById(Arrays.asList(companySeq));
		return list.stream()
				.map((entity) -> QuestionSetDto.of(entity, modelMapper))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public QuestionSetDto registQuestionSet(QuestionSetDto questionSetDto) {
		QuestionSetEntity entity = QuestionSetEntity.of(questionSetDto, modelMapper);
		CompanyEntity company = companyRepository.findById(Long.parseLong(questionSetDto.getCompanySeq())).orElse(null);
		entity.setCompany(company);
		entity.setRegisteredDate(DateUtil.nowLocalDateTime());
		entity.setModifiedDate(DateUtil.nowLocalDateTime());
		entity = questionSetRepository.save(entity);
		return QuestionSetDto.of(entity, modelMapper);
	}
	
}

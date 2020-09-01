package com.develeaf.interviewer.questionset.dto;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;

import com.develeaf.interviewer.common.dto.CommonDto;
import com.develeaf.interviewer.questionset.entity.QuestionSetEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionSetDto extends CommonDto {
	
	private Long seq;
	private String setName;
	private String author;
	private String companySeq;
	private List<QuestionDto> questionList;
	private String registeredDate;
	private String modifiedDate;
	
	public static QuestionSetDto of(QuestionSetEntity entity, ModelMapper modelMapper) {
		QuestionSetDto dto = modelMapper.map(entity, QuestionSetDto.class);
		if (entity.getQuestionListJson() != null) {
			try {
				ObjectMapper objectMapper = new ObjectMapper();
				dto.setQuestionList(objectMapper.readValue(entity.getQuestionListJson(), new TypeReference<List<QuestionDto>>() {}));
			} catch (JsonProcessingException e) {
				log.error(StringUtils.EMPTY, e);
			}
		}
		return dto;
	}
	
}

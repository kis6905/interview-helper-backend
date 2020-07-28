package com.develeaf.interviewer.questionset.dto;

import java.util.List;

import com.develeaf.interviewer.common.dto.CommonDto;
import com.develeaf.interviewer.common.utils.EntityToDtoConverter;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class QuestionSetDto extends CommonDto {
	
	private Long seq;
	private String setName;
	private String author;
	private List<QuestionDto> questionList;
	private String registeredDate;
	private String modifiedDate;
	
	public static <T, R> R convertEntityToDto(T entity, EntityToDtoConverter converter) {
		return converter.convert(entity);
	}
	
}

package com.develeaf.interviewer.questionset.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.develeaf.interviewer.company.entity.CompanyEntity;
import com.develeaf.interviewer.questionset.dto.QuestionDto;
import com.develeaf.interviewer.questionset.dto.QuestionSetDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Entity(name = "QuestionSet")
@Table(name = "question_set")
@NoArgsConstructor
@Getter
@Setter
@ToString
@Slf4j
public class QuestionSetEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long seq;
	
	@Column
	private String setName;
	
	@Column
	private String author;
	
	@Column(name = "question_list")
	private String questionListJson;
	
	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime registeredDate;
	
	@LastModifiedDate
	@Column(updatable = true)
	private LocalDateTime modifiedDate;
	
	@ManyToOne
	@JoinColumn(name = "company_seq")
	private CompanyEntity company;
	
	public static QuestionSetEntity of(QuestionSetDto dto, ModelMapper modelMapper) {
		QuestionSetEntity entity = modelMapper.map(dto, QuestionSetEntity.class);
		
		List<QuestionDto> questionList = dto.getQuestionList();
		if (questionList != null && !questionList.isEmpty()) {
			try {
				ObjectMapper objectMapper = new ObjectMapper();
				String questionListJson = objectMapper.writeValueAsString(questionList);
				entity.setQuestionListJson(questionListJson);
			} catch (JsonProcessingException e) {
				log.error(StringUtils.EMPTY, e);
			}
		}
		return entity;
	}
	
}

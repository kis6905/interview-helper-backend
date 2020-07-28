package com.develeaf.interviewer.questionset.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.develeaf.interviewer.company.entity.CompanyEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "QuestionSet")
@Table(name = "question_set")
@NoArgsConstructor
@Getter
@ToString
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
	
}

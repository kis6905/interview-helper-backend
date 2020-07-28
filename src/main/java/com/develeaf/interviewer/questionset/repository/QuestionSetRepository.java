package com.develeaf.interviewer.questionset.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.develeaf.interviewer.questionset.entity.QuestionSetEntity;

@Repository
public interface QuestionSetRepository extends JpaRepository<QuestionSetEntity, Long> {
	
}

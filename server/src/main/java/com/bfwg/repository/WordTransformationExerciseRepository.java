package com.bfwg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bfwg.model.WordTransformationExercise;

	public interface WordTransformationExerciseRepository extends JpaRepository<WordTransformationExercise, Long> {
		WordTransformationExercise findById( Long id );
		
		List<WordTransformationExercise> findByAuthorId(Long author_id);
	}
	
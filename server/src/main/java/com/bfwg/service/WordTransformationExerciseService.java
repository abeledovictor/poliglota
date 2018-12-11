package com.bfwg.service;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.bfwg.model.User;
import com.bfwg.model.UserRequest;
import com.bfwg.model.WordTransformationExercise;
import com.bfwg.model.WordTransformationExerciseRequest;

/**
 * Created by fan.jin on 2016-10-15.
 */
public interface WordTransformationExerciseService {
	HttpStatus save(WordTransformationExerciseRequest wtRequest);
	List<WordTransformationExercise> findAll();
	List<WordTransformationExercise> findByAuthorId(Long authorId);
	WordTransformationExercise findById(Long id);
}


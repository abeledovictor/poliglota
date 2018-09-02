package com.bfwg.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.bfwg.model.WordTransformationExercise;
import com.bfwg.repository.WordTransformationExerciseRepository;

@Service
public class WordTransformationExerciseService {
	  @Autowired
	  private WordTransformationExerciseRepository wtRepository;
	
	  @PreAuthorize("hasRole('ADMIN')")
	  public WordTransformationExercise findById(Long id) throws AccessDeniedException {
		  WordTransformationExercise u = wtRepository.findById(id);
	    return u;
	  }
	  
	  
	  @PreAuthorize("hasRole('ADMIN')")
	  public List<WordTransformationExercise> findAll() throws AccessDeniedException {
	    List<WordTransformationExercise> result = wtRepository.findAll();
	    return result;
	  }
	  
	  @PreAuthorize("hasRole('USER')")
	  public List<WordTransformationExercise> findByAuthorId(Long authorId) throws AccessDeniedException {
		  List<WordTransformationExercise> result = wtRepository.findByAuthorId(authorId);
		  return result;
	  }
}

package com.bfwg.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.bfwg.model.WordTransformationExercise;
import com.bfwg.model.WordTransformationExerciseRequest;
import com.bfwg.repository.WordTransformationExerciseRepository;
import com.bfwg.service.WordTransformationExerciseService;

@Service
public class WordTransformationExerciseServiceImpl implements WordTransformationExerciseService {
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
	  
	  @Override
	  @PreAuthorize("hasRole('ADMIN')")
	  public HttpStatus save(WordTransformationExerciseRequest wtRequest) {
		WordTransformationExercise wordTransformation = new WordTransformationExercise();
		wordTransformation.setAuthorId(wtRequest.getAuthor_id());

		wordTransformation.setwt_task(wtRequest.getwt_task());

	    this.wtRepository.save(wordTransformation);
	   
	    return HttpStatus.CREATED;
	  }
}
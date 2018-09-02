package com.bfwg.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.bfwg.model.Authority;
import com.bfwg.model.User;
import com.bfwg.model.UserRequest;
import com.bfwg.model.UserRoleName;
import com.bfwg.model.WordTransformation;
import com.bfwg.model.WordTransformationExercise;
import com.bfwg.model.WordTransformationExerciseRequest;
import com.bfwg.model.WordTransformationTaskRequest;
import com.bfwg.repository.WordTransformationExerciseRepository;
import com.bfwg.repository.WordTransformationTaskRepository;

@Service
public class WordTransformationExerciseService {
	  @Autowired
	  private WordTransformationExerciseRepository wtRepository;
	  
	  @Autowired
	  private WordTransformationTaskRepository wtTaskRepository;
	
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
	  
	  @PreAuthorize("hasRole('ADMIN')")
	  public WordTransformationExercise save(WordTransformationExerciseRequest wtRequest) {
		WordTransformationExercise wordTransformation = new WordTransformationExercise();
		wordTransformation.setAuthorId(wtRequest.getAuthor_id());
		System.out.println(wtRequest.getTasks());
		wordTransformation.setWordTransformations(wtRequest.getTasks());

	    this.wtRepository.save(wordTransformation);
	   
	    return wordTransformation;
	  }
}

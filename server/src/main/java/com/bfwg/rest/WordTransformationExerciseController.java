package com.bfwg.rest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.bfwg.exception.ResourceConflictException;
import com.bfwg.model.User;
import com.bfwg.model.UserRequest;
import com.bfwg.model.WordTransformationExercise;
import com.bfwg.model.WordTransformationExerciseRequest;
import com.bfwg.service.WordTransformationExerciseService;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class WordTransformationExerciseController {

	  @Autowired
	  private WordTransformationExerciseService wtService;
	  
	  
	  @RequestMapping(method = GET, value = "/word-transformation/all")
	  public List<WordTransformationExercise> loadAll() {
	    return this.wtService.findAll();
	  }
	  
	  @RequestMapping(method = GET, value = "/word-transformation/{authorId}")
	  public List<WordTransformationExercise> loadByAuthorId(@PathVariable Long authorId) {
	    return this.wtService.findByAuthorId(authorId);
	  }
	  
	  @RequestMapping(method = POST, value = "/word-transformation/new")
	  public ResponseEntity<?> addWordTransformationExercise(@RequestBody WordTransformationExerciseRequest wtRequest) {

	    WordTransformationExercise wtExercise = this.wtService.save(wtRequest);

	    return new ResponseEntity<WordTransformationExercise>(wtExercise, HttpStatus.CREATED);
	  }
}

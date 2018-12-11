package com.bfwg.rest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
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
	  @ResponseBody
	  public ResponseEntity<String> addWordTransformationExercise(@RequestBody WordTransformationExerciseRequest wtRequest) {
	    HttpStatus wtExerciseStatus = this.wtService.save(wtRequest);

	    return ResponseEntity.status(wtExerciseStatus)
	    		.contentType(MediaType.TEXT_PLAIN)
	    		.body("Word transformation exercise created successfully");

	  }
}

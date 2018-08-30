package com.bfwg.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "wt_exercise")
public class WordTransformationExercise implements Serializable {
	  @Id
	  @Column(name = "id")
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  
	  @Column(name = "author_id")
	  private Long authorId;
	  
	  
	  @Enumerated( EnumType.ORDINAL)
	  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	  @JoinTable(name = "wt_task",
	      joinColumns = @JoinColumn(name = "exercise_id", referencedColumnName = "id"),
	      inverseJoinColumns = {
	          @JoinColumn(name = "exercise_body", referencedColumnName = "body"),
	          @JoinColumn(name = "exercise_result", referencedColumnName = "result"),
	          @JoinColumn(name = "exercise_word", referencedColumnName = "word"),
	      })
	  private List<WordTransformation> wordTransformations;
}
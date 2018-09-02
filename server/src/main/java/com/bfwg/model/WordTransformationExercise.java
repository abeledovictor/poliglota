package com.bfwg.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Collection;
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
	  
	  
	  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	  @JoinTable(name = "wt_task",
		      joinColumns = @JoinColumn(name = "exercise_id", referencedColumnName = "id"),
		      inverseJoinColumns = @JoinColumn(name = "task_id", referencedColumnName = "task_id"))
	  private List<WordTransformation> wordTransformations;
	  
	  public Long getId() {
		    return id;
		  }

	  public void setId(Long id) {
		    this.id = id;
		  }
	  
	  public Long getAuthorId() {
		    return authorId;
		  }

	  public void setAuthorId(Long authorId) {
		    this.authorId = authorId;
		  }
	  
	  public void setWordTransformations(List<WordTransformation> wtTasks) {
		    this.wordTransformations = wtTasks;
		  }

		  public Collection<?> getWordTransformations() {
		    return this.wordTransformations;
		  }
}
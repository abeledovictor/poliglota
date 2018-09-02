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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.ArrayList;
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
	  private List<WordTransformation> wt_task;
	  
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
	  
	  public void setwt_task(List<WordTransformation> list) {
		  this.wt_task = list;
		  }

		  public Collection<?> getwt_task() {
		    return this.wt_task;
		  }
}
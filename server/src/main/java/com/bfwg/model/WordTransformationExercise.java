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

@Entity(name = "wt_exercise")
@Table(name = "wt_exercise")
public class WordTransformationExercise implements Serializable {
	  @Id
	  @Column(name = "id")
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  
	  @Column(name = "author_id")
	  private Long authorId;
	  
	  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	  private List<WordTransformation> wt_task = new ArrayList<>();
	  
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
	  
	  public void setwt_task(List<WordTransformationTaskRequest> list) {
		  for(WordTransformationTaskRequest task : list) {
			WordTransformation adding = new WordTransformation();
			adding.setBody(task.getBody());
			adding.setResult(task.getResult());
			adding.setword_at_index(task.getword_at_index());
			adding.setWord(task.getWord());
			this.wt_task.add(adding);
		  }
		  }

		  public Collection<?> getwt_task() {
		    return this.wt_task;
		  }
}
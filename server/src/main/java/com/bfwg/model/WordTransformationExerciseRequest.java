package com.bfwg.model;

import java.util.List;

public class WordTransformationExerciseRequest {
	private Long id;
	private Long author_id;
	private List<WordTransformationTaskRequest> wt_task;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(Long author_id) {
		this.author_id = author_id;
	}
	public List<WordTransformationTaskRequest> getwt_task() {
		return wt_task;
	}
	public void setwt_taask(List<WordTransformationTaskRequest> wt_task) {
		this.wt_task = wt_task;
		
	}

}

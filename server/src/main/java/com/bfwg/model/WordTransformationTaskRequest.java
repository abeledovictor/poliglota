package com.bfwg.model;

public class WordTransformationTaskRequest {
	private String body;
	private String word;
	private Integer word_at_index;
	private String result;
	private Long exercise_id;
	private Long task_id;

	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public Integer getword_at_index() {
		return word_at_index;
	}
	public void setword_at_index(Integer word_at_index) {
		this.word_at_index = word_at_index;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Long getExercise_id() {
		return exercise_id;
	}
	public void setExercise_id(Long exercise_id) {
		this.exercise_id = exercise_id;
	}
	public Long getTask_id() {
		return task_id;
	}
	public void setTask_id(Long task_id) {
		this.task_id = task_id;
	}

}

package com.bfwg.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wt_task")
public class WordTransformation implements Serializable {

    @Id
    @Column(name = "task_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long task_id;
    
    @Column(name = "body")
    private String body;
    
    @Column(name = "result")
    private String result;
    
    @Column(name = "word")
    private String word;
    
    @Column(name = "word_at_index")
    private Integer wordAtIndex;
    
    public void setId(Long task_id) {
    	this.task_id = task_id;
    }
    
    public Long getId() {
    	return task_id;
    }
    
    public void setBody(String body) {
    	this.body = body;
    }
    
    public String getBody() {
    	return body;
    }
    
    public void setResult(String result) {
    	this.result = result;
    }
    
    public String getResult() {
    	return result;
    }
    
    public void setWord(String word) {
    	this.word = word;
    }
    
    public String getWord() {
    	return word;
    }
	
    public void setWordAtIndex(Integer wordAtIndex) {
    	this.wordAtIndex = wordAtIndex;
    }
    
    public Integer getWordAtIndex() {
    	return wordAtIndex;
    }
}

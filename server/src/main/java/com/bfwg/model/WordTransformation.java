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
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "body")
    private String body;
    
    @Column(name = "result")
    private String result;
    
    @Column(name = "word")
    private String word;
    
    public void setId(Long id) {
    	this.id = id;
    }
    
    public Long getId() {
    	return id;
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
	
}

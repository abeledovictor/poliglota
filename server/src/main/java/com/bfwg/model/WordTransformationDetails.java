package com.bfwg.model;

import java.io.Serializable;

public class WordTransformationDetails implements Serializable {
	
private String sentence;
private String word;
private String answer;

public WordTransformationDetails(String sentence, String word, String answer) {
	this.sentence = sentence;
	this.word = word;
	this.answer = answer;
}

public String getSentence() {
	return sentence;
}
public void setSentence(String sentence) {
	this.sentence = sentence;
}
public String getWord() {
	return word;
}
public void setWord(String word) {
	this.word = word;
}
public String getAnswer() {
	return answer;
}
public void setAnswer(String answer) {
	this.answer = answer;
}
}

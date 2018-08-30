package com.bfwg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="wt_task")
public class WordTransformation {

    @Id
    @Column(name="exercise_id")
    Long exercise_id;
    

    @Column(name="body")
    UserRoleName body;
    
    @Column(name="result")
    UserRoleName result;
    
    @Column(name="word")
    UserRoleName word;
	
}

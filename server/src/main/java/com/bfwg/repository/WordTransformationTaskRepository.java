package com.bfwg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bfwg.model.WordTransformation;
import com.bfwg.model.WordTransformationTaskRequest;

public interface WordTransformationTaskRepository extends JpaRepository<WordTransformation, String> {
	void save(WordTransformationTaskRequest wtRequest);
}
package com.bfwg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bfwg.model.WordTransformation;

public interface WordTransformationTaskRepository extends JpaRepository<WordTransformation, String> {

}
package com.example.CHAT.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.CHAT.model.Tutorial;

@Repository
public interface TutorialRepository  extends MongoRepository <Tutorial, String>{
	 List<Tutorial>findByTittleContaining(String tittle);
	 List<Tutorial>findByPublished(boolean ispublished);
	
}

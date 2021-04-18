package com.example.CHAT.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.CHAT.model.Tutorial;
import com.example.CHAT.repository.TutorialRepository;

@Service
public class TutorialService {
	
	
	@Autowired
	TutorialRepository tutorialRepository;
	
	
	public ResponseEntity<Tutorial> createTutorial(Tutorial tutorial) {
		
		try {
		Tutorial tt=tutorialRepository.save(tutorial);
		return new ResponseEntity<>(tt, HttpStatus.CREATED);
		
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	} 
	public ResponseEntity<List<Tutorial>> getAllTutorials(String tittle) {
		try {
		    List<Tutorial> tutorials = new ArrayList<Tutorial>();
		
		    if (tittle == null) {
		    	tutorialRepository.findAll().forEach(tutorials::add);
		    } else {
		    	tutorialRepository.findByTittleContaining(tittle).forEach(tutorials::add);
		    }
		
		    if (tutorials.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }
		
		    return new ResponseEntity<>(tutorials, HttpStatus.OK);
		} catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	public  ResponseEntity<Tutorial>getAllById(String id){
		Optional<Tutorial>tutorial=tutorialRepository.findById(id);
		
		if(tutorial.isPresent()) {
			return new ResponseEntity<>(tutorial.get(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	
		
		}
	     public  ResponseEntity<Tutorial> updateTutorial(@PathVariable String id,@RequestBody Tutorial tutorial ) {
	    	 Optional<Tutorial> t =tutorialRepository.findById(id);
	    	 
	    	 if(t.isPresent()) {
	    		 Tutorial _tutorial=t.get();
	    		 _tutorial.setTittle(tutorial.getTittle());
	    		 _tutorial.setDiscription(tutorial.getDiscription());
	    		 _tutorial.setPublished(tutorial.isPublished());
	    		 
	    		 Tutorial updatedTutorial = tutorialRepository.save(_tutorial);
	    		 return new ResponseEntity<>(updatedTutorial,HttpStatus.OK);
	    	 }else {
	    		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    	 }
	}
	     public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable String id) {
	    	 try {
	    		 Optional<Tutorial> t =tutorialRepository.findById(id);		    	 
		    	 if(t.isPresent()) {	    		
	    		 tutorialRepository.deleteById(id);
	    		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    	 }else {
		    		 return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		    	 }
	    	 }catch(Exception e) {
	    		 return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	    		 
	    	 }
	 		
	 	}
	     public ResponseEntity<HttpStatus> deleteAllTutorial(){
	    	 try {
	    		 tutorialRepository.deleteAll();
	    		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    	 }catch (Exception e) {
	    		 return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			}
	     }
	     
	     public ResponseEntity<List<Tutorial>>getPublishedTutorial(){
	    	 try {
	    		 
	    		List<Tutorial>tutorials = tutorialRepository.findByPublished(true);
	    		
	    		if(tutorials.isEmpty()) {
	    			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    		}else {
	    			return new ResponseEntity<>(tutorials,HttpStatus.ACCEPTED);
	    		}
	    		
	    	 }catch(Exception e) {
	    		 return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	    		 
	    	 }
	 		
	 	}
	     
	}
	



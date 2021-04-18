package com.example.CHAT.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CHAT.model.Tutorial; 
import com.example.CHAT.services.TutorialService;

@CrossOrigin(origins ="http:localhost:8081")
@RestController
@RequestMapping("/api")
public class TutorialController {
	
	@Autowired
	TutorialService tutorialService;
	
	@PostMapping("/tutorials")
	public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial){
		return tutorialService.createTutorial(tutorial);
		
	}
	
	@GetMapping("/tutorials")
	public ResponseEntity<List<Tutorial>>getAllTutorials(@RequestParam(required=false)String tittle){
		
		return tutorialService.getAllTutorials(tittle);
	}
	@GetMapping("/tutorials/{id}")
	public ResponseEntity<Tutorial>getTutorialById(@PathVariable String id){
		
		return tutorialService.getAllById(id);

}
	@PutMapping("/tutorials/{id}")
	public  ResponseEntity<Tutorial> updateTutorial(@PathVariable String id,@RequestBody Tutorial tutorial ) {
		return tutorialService.updateTutorial(id, tutorial);
		
	}
	@DeleteMapping("/tutorials/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable String id) {
		return tutorialService.deleteTutorial(id);
	}
	@DeleteMapping("/tutorials")
	public ResponseEntity<HttpStatus> deleteAllTutorial() {
		return tutorialService.deleteAllTutorial();
	
}
	
	
	
	@GetMapping("/tutorials/published")
	public ResponseEntity<List<Tutorial>>getPublishedTutorial(){
		return tutorialService.getPublishedTutorial();
		
	}
}
















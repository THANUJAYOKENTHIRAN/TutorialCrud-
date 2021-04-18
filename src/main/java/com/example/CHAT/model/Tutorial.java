package com.example.CHAT.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="tutorials")
public class Tutorial {
	
	@Id
	private String id;
	@Indexed(unique = true)
	private String tittle;
	private String discription;
	private boolean published;
	
	
	public Tutorial(String id, String tittle, String discription, boolean published) {
		super();
		this.id = id;
		this.tittle = tittle;
		this.discription = discription;
		this.published = published;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTittle() {
		return tittle;
	}


	public void setTittle(String tittle) {
		this.tittle = tittle;
	}


	public String getDiscription() {
		return discription;
	}


	public void setDiscription(String discription) {
		this.discription = discription;
	}


	public boolean isPublished() {
		return published;
	}


	public void setPublished(boolean published) {
		this.published = published;
	}
	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", title=" + tittle + ", description=" + discription + ", published=" + published
				+ "]";
	}

}

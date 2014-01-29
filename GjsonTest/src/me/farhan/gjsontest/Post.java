package me.farhan.gjsontest;

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Post {

	@SerializedName("id")
	public long ID;
	public String title;
	public String author;
	public String url;
	@SerializedName("date")
	public Date dateCreated;
	public String body;
	
	public List tags;
	
	public Post() {
		
	}
}

 class Tag {
	
	public String name;
	public String url;

	public Tag() {
		
	}
}
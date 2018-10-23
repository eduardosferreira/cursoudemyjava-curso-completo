package com.curse.udemy.joo.section8.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static Long autoIncrementId=0L;
	public static Long getAutoIncrementId() {
		return autoIncrementId;
	}
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private Long   id;
	private Date moment;
	private String title;
	private String content;
	private Long likes;
	private List<Comment> comments = new ArrayList<>();
	
	
	public Long getId() {
		return id;
	}
	public Date getMoment() {
		return moment;
	}
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getLikes() {
		return likes;
	}
	public void setLikes(Long likes) {
		this.likes = likes;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void addComment(Comment comment) {
		this.comments.add(comment);
	}
	public void removeComment(Comment comment) {
		this.comments.remove(comment);
	}
	
	private Post() {
		super();
		autoIncrementId++;
	}	
	
	public Post(Date moment, String title, String content, Long likes) {
		this();
		this.id = Comment.getAutoIncrementId();
		this.moment = moment;
		this.title = title;
		this.content = content;
		this.likes = likes;
	}

	
	
	@Override
	public String toString() {
		StringBuffer c = new StringBuffer();
		for (Comment comment : comments) {
			c.append(comment.getText() + " \n" );
		}
		return this.title   + " \n" +  
			   this.likes   + " Likes - "  + sdf.format(this.moment)  +  " \n" +
			   this.content  + " \n" +
			   "Comments: "  + " \n" +
			   c.toString() +
			   "";	
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
	
	
	
}

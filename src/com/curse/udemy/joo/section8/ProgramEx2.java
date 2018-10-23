package com.curse.udemy.joo.section8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.curse.udemy.joo.section8.entities.Comment;
import com.curse.udemy.joo.section8.entities.Post;

public class ProgramEx2 {

	private ProgramEx2() {
		Locale.setDefault(Locale.US);
		System.out.println();
	}


	public static void main(String[] args) {

		Post p1, p2;
		Comment c1 = new Comment("Have a nice trip");
		Comment c2 = new Comment("Wow that's awesome!");
		Comment c3 = new Comment("Good night!");
		Comment c4 = new Comment("May the Force be with you");
		
		try {
			p1 = new Post(Post.sdf.parse("21/06/2018 13:05:44"), "Traveling to New Zealand", "I'm going to visit this wonderful country!", 12l);
			p1.addComment(c1);
			p1.addComment(c2);

			p2 = new Post(Post.sdf.parse("28/07/2018 23:14:19"), "Good night guys", "See you tomorrow.", 5l);
			p2.addComment(c3);
			p2.addComment(c4);
			
			System.out.println(p1);
			System.out.println(p2);			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
	}
	
	
}

package com.emolog.model;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

public class Diary {
  
  private UUID diary_id, author_id;
  private String calendar_date, diary_title, diary_emotion, diary_content, diary_pw;
  
  @Autowired
  public Diary () {
    
  }
  
  @Autowired
  public Diary (UUID author_id, String calendar_date, String diary_title, String diary_emotion, String diary_content) {
    this.author_id = author_id;
    this.calendar_date = calendar_date;
    this.diary_title = diary_title;
    this.diary_emotion = diary_emotion;
    this.diary_content = diary_content;
  }
  
  public void show() {
    // this is for temporary uses
    System.out.println(diary_title + " --by " + author_id);
    System.out.println(calendar_date + " " + diary_emotion);
    System.out.println(diary_content);
  }
  
  public void setContent(String content) {
	  this.diary_content = content;
  }
  
  @Override
  public String toString() {
	  return "Diary{" +
			  "diary_title=" + diary_title +
			  "author_id=" + author_id + 
			  "calendar_date=" + calendar_date +
			  "diary_emotion=" + diary_emotion +
			  "diary_content=" + diary_content +
			  "}";
  }
}
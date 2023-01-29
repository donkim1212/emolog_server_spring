package com.emolog.model;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.Table;

@Entity
//@Table(name="diary")
public class Diary {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private UUID diary_id;
	
	private UUID author_id;
	private String calendar_date, diary_title, diary_emotion, diary_content, diary_pw;

	@Autowired
	public Diary(UUID author_id, String calendar_date, String diary_title, String diary_emotion, String diary_content) {
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

	public void setDiaryId(UUID id) {
		this.diary_id = id;
	}

	public UUID getDiaryId() {
		return diary_id;
	}

	public UUID getAuthorId() {
		return author_id;
	}

	public String getCalendarDate() {
		return calendar_date;
	}

	public String getDiaryTitle() {
		return diary_title;
	}

	public String getDiaryEmotion() {
		return diary_emotion;
	}

	public String getDiaryContent() {
		return diary_content;
	}

	public String getDiaryPw() {
		return diary_pw;
	}

	@Override
	public String toString() {
		return "Diary{" + "diary_title=" + diary_title + "author_id=" + author_id + "calendar_date=" + calendar_date
				+ "diary_emotion=" + diary_emotion + "diary_content=" + diary_content + "}";
	}
}
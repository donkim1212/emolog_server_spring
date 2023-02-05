package com.emolog.entity;

import java.sql.Time;
import java.time.OffsetDateTime;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="diaries")//, schema="public")
public class DiaryEntity {

	@Id
	@GeneratedValue(generator="uuid4")
	@GenericGenerator(name="uuid4", strategy="org.hibernate.id.UUIDGenerator")
	@Column(name="diary_id", nullable=false)
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@UuidGenerator
	private UUID diary_id;
	
	@Column(name="author_id")
	private UUID author_id;
	@Column(name="calendar_date")
	private String calendar_date;
	@Column(name="diary_title")
	private String diary_title;
	@Column(name="diary_emotion")
	private String diary_emotion;
	@Column(name="diary_content")
	private String diary_content;
	@Column(name="diary_pw", columnDefinition="varchar(255) default NULL::character varying")
	private String diary_pw;
	
//	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private OffsetDateTime created_at;
//	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private OffsetDateTime updated_at;
	
	public DiaryEntity() {
		super();
	}
	
	public DiaryEntity(UUID author_id, String calendar_date, String diary_title, String diary_emotion, String diary_content, String diary_pw) {
		this.author_id = author_id;
		this.calendar_date = calendar_date;
		this.diary_title = diary_title;
		this.diary_emotion = diary_emotion;
		this.diary_content = diary_content;
		this.diary_pw = diary_pw;
	}

//	@Autowired
	public DiaryEntity(UUID author_id, String calendar_date, String diary_title, String diary_emotion,
			String diary_content, String diary_pw, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
		this.author_id = author_id;
		this.calendar_date = calendar_date;
		this.diary_title = diary_title;
		this.diary_emotion = diary_emotion;
		this.diary_content = diary_content;
		this.diary_pw = diary_pw;
		this.created_at = createdAt;
		this.updated_at = updatedAt;
		
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

	public OffsetDateTime getCreatedAt() {
		return created_at;
	}

	public void setCreatedAt(OffsetDateTime createdAt) {
		this.created_at = createdAt;
	}

	public OffsetDateTime getUpdatedAt() {
		return updated_at;
	}

	public void setUpdatedAt(OffsetDateTime updatedAt) {
		this.updated_at = updatedAt;
	}
	
	public boolean Equals(DiaryEntity other) {
		return this.diary_id.equals(other.diary_id);
	}
	
	/*
	public void show() {
		// this is for temporary uses
		System.out.println(diary_title + " --by " + author_id);
		System.out.println(calendar_date + " " + diary_emotion);
		System.out.println(diary_content);
	}
	*/
	
	/*
	@Override
	public String toString() {
		return "Diary{" + "diary_title=" + diary_title + "author_id=" + author_id + "calendar_date=" + calendar_date
				+ "diary_emotion=" + diary_emotion + "diary_content=" + diary_content + "}";
	}
	*/
}
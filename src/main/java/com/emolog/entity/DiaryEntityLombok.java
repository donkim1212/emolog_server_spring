package com.emolog.entity;

import java.sql.Time;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString(exclude="diary_pw")
@Table(name="diaries")//, schema="public")
public class DiaryEntityLombok {
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
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="createdAt")
	private Time createdAt;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updatedAt")
	private Time updatedAt;
	
}

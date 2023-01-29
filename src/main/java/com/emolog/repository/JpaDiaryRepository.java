package com.emolog.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.emolog.model.Diary;

import jakarta.persistence.EntityManager;

@Repository
@Primary
public class JpaDiaryRepository implements DiaryRepository {

	private final EntityManager em;

	public JpaDiaryRepository(EntityManager em) {
		this.em = em;
	}

	@Override
	public Diary save(Diary entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public Optional<Diary> findById(UUID diary_id) {
		Diary diary = em.find(Diary.class, diary_id);
		return Optional.ofNullable(diary);
	}

	@Override
	public Optional<Diary> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Diary> findAll() {
		return em.createQuery("select d from Diary d", Diary.class).getResultList();
	}

	@Override
	public Optional<Diary> findAllDiariesByAuthorId(UUID author_id) {
		List<Diary> list = em.createQuery("select d from Diary d where d.author_id = :author_id", Diary.class)
			.setParameter("author_id", author_id)
			.getResultList();
		return list.stream().findAny();
	}

	@Override
	public List<Diary> findLimitedDiariesByAuthorId(UUID author_id, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	/**
	 * Works just like findById
	 */
	public Diary findDiaryByAccAndID(String accToken, UUID diary_id) {
		return em.createQuery("select d from Diary d where d.author_id = :id", Diary.class)
			.setParameter("id", diary_id)
			.getSingleResult();
	}

}

package com.emolog.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emolog.entity.DiaryEntity;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
//@Primary
public class CustomDiaryRepository implements IDiaryRepository {

	@Autowired
	private final EntityManager em;

	@Autowired
	public CustomDiaryRepository(EntityManager em) {
		this.em = em;
	}

	@Override
	public DiaryEntity save(DiaryEntity entity) {
		try {
			em.persist(entity);
//			em.flush();
			System.out.println("JpaDiaryRepository: Save successful.");
			return entity;
		} catch (Exception e) {
			System.out.println("JpaDiaryRepository: An exception occurred.");
			System.out.println(e.getClass());
			System.out.println(e.getCause());
			return null;
		}
	}

	@Override
	public Optional<DiaryEntity> findById(UUID diary_id) {
		DiaryEntity diary = em.find(DiaryEntity.class, diary_id);
		return Optional.ofNullable(diary);
	}

	@Override
	public Optional<DiaryEntity> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DiaryEntity> findAll() {
		return em.createQuery("select d from DiaryEntity d", DiaryEntity.class).getResultList();
	}

	@Override
	public Optional<DiaryEntity> findAllDiariesByAuthorId(UUID author_id) {
		List<DiaryEntity> list = em.createQuery("select d from DiaryEntity d where d.author_id = :author_id", DiaryEntity.class)
			.setParameter("author_id", author_id)
			.getResultList();
		return list.stream().findAny();
	}

	@Override
	public Optional<DiaryEntity> findLimitedDiariesByAuthorId(UUID author_id, int limit) {
		List<DiaryEntity> list = em.createQuery("select d from DiaryEntity d where d.author_id = :author_id", DiaryEntity.class)
				.setParameter("author_id", author_id)
				.setMaxResults(limit)
				.getResultList();
		return list.stream().findAny();
	}

	/**
	 * Works just like findById
	 */
	@Override
	public DiaryEntity findDiaryByAccAndID(String accToken, UUID diary_id) {
		return em.createQuery("select d from DiaryEntity d where d.author_id = :id", DiaryEntity.class)
			.setParameter("id", diary_id)
			.getSingleResult();
	}

}

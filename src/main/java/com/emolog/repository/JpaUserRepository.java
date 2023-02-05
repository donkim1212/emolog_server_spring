package com.emolog.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emolog.entity.UserEntity;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class JpaUserRepository implements IUserRepository{
	@Autowired
	private final EntityManager em;
	
	@Autowired
	public JpaUserRepository (EntityManager em) {
		this.em = em;
	}

	@Override
	@Transactional
	public UserEntity save(UserEntity entity) {
		try {
			em.persist(entity);
			return entity;
		} catch (Exception e) {
			System.out.println("JpaUserRepository: An error occurred.");
			System.out.println(e.getClass());
			System.out.println(e.getCause());
			return null;
		}
	}

	@Override
	public Optional<UserEntity> findById(UUID user_id) {
		
		return null;
	}

	@Override
	public Optional<UserEntity> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<UserEntity> findUserByEmailLoginType(String email, String login_type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<UserEntity> newAccessTokenFromRefreshToken(UUID user_id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

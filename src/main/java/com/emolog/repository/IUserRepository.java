package com.emolog.repository;

import java.util.Optional;
import java.util.UUID;

import com.emolog.entity.UserEntity;

public interface IUserRepository extends IModelRepository<UserEntity, UUID> {
	Optional<UserEntity> findUserByEmailLoginType(String email, String login_type);
	Optional<UserEntity> newAccessTokenFromRefreshToken(UUID user_id);
}

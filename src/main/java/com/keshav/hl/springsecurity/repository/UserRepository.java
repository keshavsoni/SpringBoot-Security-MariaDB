package com.keshav.hl.springsecurity.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.keshav.hl.springsecurity.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
	
	@EntityGraph(value="UserEntity.address")
	List<UserEntity> findByUsername(String username);
	
	@EntityGraph(value="UserEntity.address")
	List<UserEntity> findAll();
}

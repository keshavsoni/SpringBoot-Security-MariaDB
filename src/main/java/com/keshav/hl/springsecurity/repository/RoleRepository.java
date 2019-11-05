package com.keshav.hl.springsecurity.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.keshav.hl.springsecurity.entity.RoleEntity;
import com.keshav.hl.springsecurity.entity.UserEntity;

public interface RoleRepository {
	
	List<RoleEntity> findAllRoleNameIn(Set<String> RoleName);
	List<UserEntity> findAllUSersDetails();

}

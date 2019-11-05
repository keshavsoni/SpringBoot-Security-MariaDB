package com.keshav.hl.springsecurity.repository;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.keshav.hl.springsecurity.entity.RoleEntity;
import com.keshav.hl.springsecurity.entity.UserEntity;

@Repository
@SuppressWarnings("unchecked")
public class RoleRepositoryImpl implements RoleRepository {

	
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public List<RoleEntity> findAllRoleNameIn(Set<String> RoleName) {
		
		Query q = entityManager.createQuery("select * from roles where role_name in(:roles)");
		q.setParameter("roles", RoleName);		
		List<RoleEntity> listOfroles = q.getResultList();
		
		return listOfroles;
	}

	@Override
	@Transactional
	public List<UserEntity> findAllUSersDetails() {
		
		Query q = entityManager.createQuery("");
		
		
		return null;
	}

}

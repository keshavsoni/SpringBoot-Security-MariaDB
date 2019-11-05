package com.keshav.hl.springsecurity.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Keshav Soni
 *
 */
@Entity
@Table(name="roles")
@Data
@NoArgsConstructor
public class RoleEntity extends BaseEntity implements Serializable {
	
	
	private static final long serialVersionUID = -4930814747986916203L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long roleid;
	
	private String roleName;
	
	private String roleStatus;
	
	@ManyToMany(mappedBy="roles")
	private Set<UserEntity> users;
}

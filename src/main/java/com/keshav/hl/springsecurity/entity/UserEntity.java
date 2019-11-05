package com.keshav.hl.springsecurity.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user_info")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
@NamedEntityGraph(name="UserEntity.address",attributeNodes= @NamedAttributeNode("address")) 
public class UserEntity extends BaseEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7010148987654409205L;

		
	@Id
	@GeneratedValue(generator="uuid2")
	@GenericGenerator(name="uuid2", strategy="uuid2")
	@Column(name="user_guid")
    private UUID userId;

    @Column(name="firstName")
    private String firstName;
    
    @Column(name="lastName")
    private String lastName;
    
    @Column(name="unique_username",unique=true)
	private String username;
	
    @Column(name="password")
	private String password;
	
	@Transient
	private String confirmPassword;
    
    @Column(name="Email",unique=true)
    private String email;
    
    @Column(name="Mobile",length=10)
    private Long mobile;
	
    @Column(name="date")
	private int date;
	
    @Column(name="month")
	private int month;
	
    @Column(name="year")
	private int year;
    
    @Column(name="gender")
	private String gender;
	
	@ManyToMany
	private List<RoleEntity> roles;
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="user_guid",nullable=false,updatable=false)
	private Set<AddressEntity> address = new HashSet<>();
	
	

}

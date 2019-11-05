package com.keshav.hl.springsecurity.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="address_info")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class AddressEntity extends BaseEntity implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8081767243861857846L;

	@Id
	@GeneratedValue(generator="uuid2")
	@GenericGenerator(name="uuid2", strategy="uuid2")
	@Column(name="address_id",columnDefinition = "BINARY(16)")
	private UUID addressID;
	
	@Column(name="address_Area")	
	private String area;
	
	@Column(name="address_Street")	
	private String street;
	
	@Column(name="address_Landmark")	
	private String landmark;
	
	@Column(name="address_City")	
	private String city;
	
	@Column(name="address_State")
	private String state;
	
	@Column(name="address_Country")
	private String country;
	
	@Column(name="address_ZipCode")
	private int zipCode;
	
	/*@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="user_guid",nullable=false,updatable=false)
	private UserEntity userEntity;*/
	

}

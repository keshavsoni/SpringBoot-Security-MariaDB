package com.keshav.hl.springsecurity.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4897834488788626978L;
	
	@Column(name = "CREATED_ON")
    private Date createdOn;

    @Column(name = "CREATED_BY", columnDefinition = "VARCHAR(50)")
    private String createdBy;

    @Column(name = "UPDATED_ON")
    private Date updatedOn;

    @Column(name = "UPDATED_BY", columnDefinition = "VARCHAR(50)")
    private String updatedBy;

    @Column(name = "ROW_STATUS")
    private int rowStatus;

}

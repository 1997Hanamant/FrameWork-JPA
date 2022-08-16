package com.xworkz.pub.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@MappedSuperclass

public class ParentEntity {
	@Column(name = "createdby")
	private String createBy;
	@Column(name = "createddate")
	private LocalDate createDate;
	@Column(name = "updatedby")
	private String updatedBy;
	@Column(name = "updateddate")
	private LocalDate updatedDated;

}

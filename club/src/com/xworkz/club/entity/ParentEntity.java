package com.xworkz.club.entity;

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
	@Column(name="createBy")
	private String createdBy;
	@Column(name = "createdate")
	private LocalDate createdDate;
	@Column(name = "updatedby")
	private String updateBy;
	@Column(name = "updateddate")
	private LocalDate updatedDate;

}

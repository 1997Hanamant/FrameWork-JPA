package com.xworkz.cafe.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name="cafe_info")

public class CafeEntity implements Serializable{
	@Id
	@Column(name="id")
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="location")
	private String location;
	@Column(name="opentime")
	private LocalTime openTime;
	@Column(name="closetime")
	private LocalTime closeTime;
	@ Column(name="createdby")
	private String  createdBy;
	@Column(name="createddate")
	private LocalDate createdDate;
	@Column(name="updateby")
	private String  upDatedBy;
	@Column(name="updateddate")
	private LocalDate upDatedDate;
	


}

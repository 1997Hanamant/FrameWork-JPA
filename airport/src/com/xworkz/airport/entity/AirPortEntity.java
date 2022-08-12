package com.xworkz.airport.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
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
@Table(name="airport_info")
public class AirPortEntity implements Serializable {
	@Id
	@Column(name="id")
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="location")
	private String Location;
	@Column(name="type")
	private String type;
	@Column(name="area")
	private String area;
	@Column(name="createdby")
	private String createdBy;
	@Column(name="crearedate")
	private LocalDate createdDate;
	@Column(name="updatedby")
	private String upDatedBy;
	@Column(name="updateddate")
	private LocalDate upDatedDate;

}

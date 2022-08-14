package com.xworkz.pub.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "pub_info")
@NamedQueries({ @NamedQuery(name = "findByName", query = "Select pub from PubEntity pub where pub.name=:nm"),
@NamedQuery(name = "findByNameAndLocation", query = "Select pub from PubEntity pub where pub.name=:nm and pub.location=:loc") })
public class PubEntity implements Serializable {
	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "location")
	private String location;
	@Column(name = "checkintime")
	private LocalTime checkInTime;
	@Column(name = "checkouttime")
	private LocalTime checkOutTime;
	@Column(name = "createdby")
	private String createBy;
	@Column(name = "createddate")
	private LocalDate createDate;
	@Column(name = "updatedby")
	private String updatedBy;
	@Column(name = "updateddate")
	private LocalDate updatedDated;

}

package com.xworkz.club.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
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
@Table(name = "club_info")
@NamedQueries({ @NamedQuery(name = "findByName", query = "select club From ClubEntity club where club.name=:nm"),
@NamedQuery(name = "findByNameAndLocation",query="select club From ClubEntity club where club.name=:nm and club.location=:loc") })

public class ClubEntity implements Serializable {
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
	@Column(name = "createby")
	private String createdBy;
	@Column(name = "createdate")
	private LocalDate createdDate;
	@Column(name = "updatedby")
	private String updateBy;
	@Column(name = "updateddate")
	private LocalDate updatedDate;

}

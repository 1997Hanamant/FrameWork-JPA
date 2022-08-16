package com.xworkz.club.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "club_info")
@NamedQueries({ @NamedQuery(name = "findByName", query = "select club From ClubEntity club where club.name=:nm"),
		@NamedQuery(name = "findByNameAndLocation", query = "select club From ClubEntity club where club.name=:nm and club.location=:loc") })

public class ClubEntity extends ParentEntity {
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

	public ClubEntity(Integer id, String name, String location, LocalTime checkInTime, LocalTime checkOutTime,
			String createdBy, LocalDate createdDate, String updateBy, LocalDate updatedDate) {
		super(createdBy,createdDate,updateBy,updatedDate);
		this.id = id;
		this.name = name;
		this.location = location;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
	}

}

package com.xworkz.oyo.entity;

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
@Table(name="oyo_info")
public class OyoEntity implements Serializable {
	@Id
	@Column(name="id")
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="location")
	private String location;
	@Column(name="checkintime")
	private LocalTime checkInOut;
	@Column(name="checkouttime")
	private LocalTime checkOutTime;
	@Column(name="createdby")
	private String createdBy;
	@Column(name="createddate")
	private LocalDate createdDate;
	@Column(name="owner")
	private String owner;
	@Column(name="priceperday")
	private Double perPerDay;

}

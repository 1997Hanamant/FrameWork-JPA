package com.xworkz.markets.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@Entity

@Table(name = "market_info")

public class MarketEntity extends ParentEntity {
	@Id
	@Min(value = 1, message = "id is not valid")
	private Integer id;
	@NotNull
	private String name;
	@PastOrPresent
	private LocalDate establishedDate;
	@Min(value=100)
	@Max(value=20000)
	private Double capacity;
	@NotNull
	private String location;
	public MarketEntity(Integer id, String name, LocalDate establishedDate, Double capacity, String location,
			String createdBy, LocalDate createdDate, String updatedBy, LocalDate updatedDate) {
		super(createdBy, createdDate, updatedBy, updatedDate);
		this.id = id;
		
		this.name = name;
		this.establishedDate = establishedDate;
		this.capacity = capacity;
		this.location = location;
	}

}

package com.xworkz.markets.entity;

import java.time.LocalDate;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@MappedSuperclass
public class ParentEntity {
	@NotNull
	 private String createdBy;
	@PastOrPresent
	 private LocalDate createdDate;
	@NotNull
	 private String updatedBy;
	@PastOrPresent
	 private LocalDate updatedDate;
}

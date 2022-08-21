package com.xworkz.cartoon.entity;

import java.time.LocalDate;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@MappedSuperclass

@Data

public class ParentCartoonEntity {
	@NotNull
	private String createdBy;
	@PastOrPresent
	private LocalDate createdDate;
	@NotNull
	private String updatedBy;
	@PastOrPresent
	private LocalDate updatedDate;

}

package com.xworkz.freedomfighter.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name="freedomfighter_info")

public class FreedomFighterEntity extends ParentEntity{
	@Id
	@GenericGenerator(name = "boss", strategy = "increment")
	@GeneratedValue(generator = "boss")
	private Integer id;
	private String name;
	private LocalDate dateOfBirth;
	private LocalDate deathDate;
	private String gender;
	private String birthLocation;
	public FreedomFighterEntity( String name, LocalDate dateOfBirth, LocalDate deathDate, String gender,
			String birthLocation, String createdBy, LocalDate createdDate, String updatedBy, LocalDate updatedDate) {
		super(createdBy,createdDate,updatedBy,updatedDate);
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.deathDate = deathDate;
		this.gender = gender;
		this.birthLocation = birthLocation;
		
	}

}

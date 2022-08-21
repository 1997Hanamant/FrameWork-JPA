package com.xworkz.cartoon.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "cartoon_info")

@NamedQueries({
		 @NamedQuery(name = "findByName", query = "select cartoon from CartoonEntity cartoon where cartoon.name=:nm"),
		// @NamedQuery(name = "findByNameAndCountryAndGenderAndAuthor", query = "select
		// cartoon from CartoonEntity cartoon where cartoon.name=:ns and
		// cartoon.country=:con and cartoon.gender=:gen and cartoon.author=:aut "),
		// @NamedQuery(name="findAuthorByName",query = "select cartoon.author from
		// CartoonEntity cartoon where cartoon.name=:nn"),
		// @NamedQuery(name="findNameAndCountryByAuthor",query = "select
		// cartoon.name,cartoon.country from CartoonEntity cartoon where
		// cartoon.author=:ar"),
		// @NamedQuery(name="findCreatedDateByAuthor",query = "select
		// cartoon.createdDate from CartoonEntity cartoon where cartoon.author=:ah"),
		// @NamedQuery(name="total",query="select count(*) from CartoonEntity"),

		// @NamedQuery(name = "updateAuthorByName", query = "update CartoonEntity
		// cartoon set cartoon.author=:tr where cartoon.name=:as"),
		// @NamedQuery(name="updateTypeByName",query = "update CartoonEntity cartoon set
		// cartoon.type=:ty where cartoon.name=:ao"),
		// @NamedQuery(name="deleteByName",query = "delete from CartoonEntity cartoon
		// where cartoon.name=:hs").
		// @NamedQuery(name = "findByMaxCreatedDate", query = "select
		// max(createdDate),cartoon from CartoonEntity cartoon"),
//		@NamedQuery(name = "findAll", query = "select info From CartoonEntity info "),
//		@NamedQuery(name = "findAllByAuthor", query = "select info From CartoonEntity info where info.author=:ax"),
//		@NamedQuery(name = "findAllByAuthorAndGender", query = "select info From CartoonEntity info where info.author=:az and info.gender=:ge"),
//		@NamedQuery(name = "findAllName", query = "select info.name From CartoonEntity info "),
//		@NamedQuery(name = "findAllCountry", query = "select info.country From CartoonEntity info "),
//		@NamedQuery(name = "findAllNameAndCountry", query = "select info.name,info.country From CartoonEntity info "),
//		@NamedQuery(name = "findAllNameAndCountryAndAuthor", query = "select info.name,info.country,info.author From CartoonEntity info") 
		 })
public class CartoonEntity extends ParentCartoonEntity {
	@Id

	 @Min(value=1, message="id is not valid")
	private Integer cid;
	@NotNull
	private String name;
	@NotNull
	private String country;
	@NotNull
	private String gender;
	@NotNull
	private String author;
	@NotNull
	private String type;

	public CartoonEntity(String name, String country, String gender, String author, String type, String createdBy,
			LocalDate createdDate, String updatedBy, LocalDate updatedDate) {
		super(createdBy, createdDate, updatedBy, updatedDate);
		this.name = name;
		this.country = country;
		this.gender = gender;
		this.author = author;
		this.type = type;
	}

}

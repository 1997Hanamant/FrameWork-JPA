package com.xworkz.cartoon.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "cartoon_info")

@NamedQueries({
	// @NamedQuery(name = "findAuthorByName", query = "select cartoon from
	// CartoonEntity cartoon where cartoon.name=nm "),
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
	//	@NamedQuery(name = "updateAuthorByName", query = "update  author CartoonEntity  set author=:qw where name=:as"),
	//@NamedQuery(name="updateTypeByName",query = "update type CartoonEntity set type=:ty  where name=:rs"),
	@NamedQuery(name="deleteByName",query = "delete from CartoonEntity c where c.name=:hs")
})

public class CartoonEntity extends ParentCartoonEntity {
	@Id
	@GenericGenerator(name = "boss", strategy = "increment")
	@GeneratedValue(generator = "boss")
	private Integer cid;
	private String name;
	private String country;
	private String gender;
	private String author;
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

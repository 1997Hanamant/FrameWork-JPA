package com.xworkz.cartoon.dao;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import com.xworkz.cartoon.entity.CartoonEntity;

public interface CartoonEntityDAO {

	boolean saveAll(List<CartoonEntity> cartoonEntities);

	default CartoonEntity findByName(String name) {
		return null;
	}
	CartoonEntity findByMaxCreatedDate();
	CartoonEntity findByNameAndCountryAndGenderAndAuthor(String name, String country, String gender, String author);
	String findAuthorByName(String name);
	Object[] findNameAndCountryByAuthor(String author);
	LocalDateTime findCreatedDateByAuthor(String author);
	Integer total();
	void updateAuthorByName(String author,String name);
	void updateTypeByName(String type,String name);
	void deleteByName(String name);
	default List <CartoonEntity> findAll(){
		return Collections.emptyList();
	}
	default List<CartoonEntity> findAllByAuthor(String author) {
		return null;
	}
	default List<CartoonEntity> findAllByAuthorAndGender(String author,String gender) {
		return null;
	}
	default List<String> findAllName() {
		return null;
	}
	 default List<String> findAllCountry() {
		return null;
	}
	default List<Object[]> findAllNameAndCountry() {
		return Collections.emptyList();
	}
	default List<Object[]> findAllNameAndCountryAndAuthor() {
		return null;
	}
	

}

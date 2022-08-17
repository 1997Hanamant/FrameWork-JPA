package com.xworkz.cartoon.dao;

import java.time.LocalDateTime;
import java.util.List;

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

}

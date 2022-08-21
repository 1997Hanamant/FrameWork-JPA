package com.xworkz.cartoon.service;

import java.util.List;

import com.xworkz.cartoon.entity.CartoonEntity;

public interface CartoonService {
	boolean validateAndSaveAll(List<CartoonEntity> cartoonEntities);

	CartoonEntity findByName(String name);

	CartoonEntity findByNameAndCountryAndGenderAndAuthor(String name, String country, String gender, String author);
}
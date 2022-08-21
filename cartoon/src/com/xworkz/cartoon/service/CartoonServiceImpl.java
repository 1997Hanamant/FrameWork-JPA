package com.xworkz.cartoon.service;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.xworkz.cartoon.dao.CartoonEntityDAO;
import com.xworkz.cartoon.dao.CartoonEntityDAOImpl;
import com.xworkz.cartoon.entity.CartoonEntity;

public class CartoonServiceImpl implements CartoonService {
	CartoonEntityDAO dao =new CartoonEntityDAOImpl();

	@Override
	public boolean validateAndSaveAll(List<CartoonEntity> cartoonEntities) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<List<CartoonEntity>>> violations = validator.validate(cartoonEntities);
		if (violations.size() > 0) {
			System.err.println("Invalid");
		} else {
			System.out.println("valid");
			dao.saveAll(cartoonEntities);


		}
		return false;
	}

	@Override
	public CartoonEntity findByName(String name) {
		ValidatorFactory factory=Validation.buildDefaultValidatorFactory();
		Validator validator=factory.getValidator();
		Set<ConstraintViolation<String>>violations=validator.validate(name);
		if(violations.size()>0) {
			System.err.println("Invlaid");
		}
		else {
			System.out.println("valid");
			dao.findByName(name);
		}
		return null;
	}

	@Override
	public CartoonEntity findByNameAndCountryAndGenderAndAuthor(String name, String country, String gender,
			String author) {
ValidatorFactory factory	=Validation.buildDefaultValidatorFactory();
Validator validator=factory.getValidator();
Set<ConstraintViolation<CartoonEntity>> violations=validator.validate(name, country,gender,author);

		return null;
	}

	

}

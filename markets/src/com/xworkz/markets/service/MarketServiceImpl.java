package com.xworkz.markets.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.xworkz.markets.dao.MarketDAO;
import com.xworkz.markets.dao.MarketDAOImpl;
import com.xworkz.markets.entity.MarketEntity;

public class MarketServiceImpl implements MarketService {
	MarketDAO dao=new MarketDAOImpl();

	@Override
	public boolean saveAndValidate(MarketEntity marketEntity) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<MarketEntity>> violation = validator.validate(marketEntity);
		if(violation.size()>0) {
			System.err.println("Invalid");
		}
		else {
			System.out.println("valid");
			dao.saveAndValidate(marketEntity);
		
		}
		return false;
	}

}

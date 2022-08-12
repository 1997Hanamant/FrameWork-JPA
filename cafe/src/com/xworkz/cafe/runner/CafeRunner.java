package com.xworkz.cafe.runner;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.EntityTransaction;

import com.xworkz.cafe.dao.CafeDAO;
import com.xworkz.cafe.dao.CafeDAOImpl;
import com.xworkz.cafe.entity.CafeEntity;

public class CafeRunner {

	public static void main(String[] args) {
		CafeEntity cafeEntity = new CafeEntity(3, "Muttu", "Jp nagar", LocalTime.of(6, 00), LocalTime.of(11, 00), "Kiran",
				LocalDate.of(2018, 07, 04), "Shankar", LocalDate.of(2016, 05, 02));
		CafeDAO cafeDAO=new CafeDAOImpl();
		cafeDAO.save(cafeEntity);

		CafeEntity entity = cafeDAO.findById(3);
		System.out.println(entity);	
		
		cafeDAO.updateNameById("Charan", 1);
		
		cafeDAO.deleteById(1);

	}

}

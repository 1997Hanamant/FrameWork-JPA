package com.xworkz.pub.runner;

import java.time.LocalDate;
import java.time.LocalTime;

import com.xworkz.pub.dao.PubDAO;
import com.xworkz.pub.dao.PubDAOImpl;
import com.xworkz.pub.entity.PubEntity;

public class PubRunner {

	public static void main(String[] args) {
		PubEntity pubEntity=new PubEntity();
		pubEntity.setId(3);
		pubEntity.setName("mallavva");
		pubEntity.setLocation("BTM 3rdt Stage");
		pubEntity.setCheckInTime(LocalTime.of(12, 00));
		pubEntity.setCheckOutTime(LocalTime.of(11, 00));
		pubEntity.setCreateBy("Mallavva");
		pubEntity.setCreateDate(LocalDate.now());
		pubEntity.setUpdatedBy("mallu");
		pubEntity.setUpdatedDated(LocalDate.now());

		PubDAO pubDAO=new PubDAOImpl();
		boolean save=pubDAO.save(pubEntity);
		System.out.println(save);

		PubEntity entity=pubDAO.findById(2);
		System.out.println(entity);
		
		pubDAO.updateNameAndLocationByID("Sujata", "Hubli", 1);
		
		pubDAO.deleteById(2);


	}

}

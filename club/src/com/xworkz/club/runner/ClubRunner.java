package com.xworkz.club.runner;

import java.time.LocalDate;
import java.time.LocalTime;

import com.xworkz.club.dao.ClubDAO;
import com.xworkz.club.dao.ClubDAOImpl;
import com.xworkz.club.entity.ClubEntity;

public class ClubRunner {

	public static void main(String[] args) {
		ClubEntity clubEntity = new ClubEntity(1, "Idigo", "Indra nagar", LocalTime.of(12, 00), LocalTime.of(11, 00),
				"Sharat", LocalDate.now(), "Nandan", LocalDate.now());
		ClubEntity clubEntity1 = new ClubEntity(2, "Saroja", "Bagalakot Navagar", LocalTime.of(12, 00), LocalTime.of(11, 00),
				"Chandru", LocalDate.now(), "Nandesh", LocalDate.now());
		ClubEntity clubEntity2 = new ClubEntity(3, "Magala", "Hubli Navagar", LocalTime.of(12, 00), LocalTime.of(11, 00),
				"Ravi", LocalDate.now(), "Ramesh", LocalDate.now());
		ClubDAO clubDAO=new ClubDAOImpl();
		boolean save=clubDAO.save(clubEntity);
		System.out.println(save);
		System.out.println("*************************");
		boolean save1	=clubDAO.save(clubEntity1);
		System.out.println(save1);
		System.out.println("*************************");
		boolean save2=clubDAO.save(clubEntity2);
		System.out.println(save2);
		
		System.out.println("*************************");
		ClubEntity entity=clubDAO.findById(2);
		System.out.println(entity);

		System.out.println("*************************");
		clubDAO.updateCreatedByAndCreatedDateById("Manu", LocalDate.now(), 2);
		
		System.out.println("*************************");
		clubDAO.deleteById(2);
	
		





	}

}

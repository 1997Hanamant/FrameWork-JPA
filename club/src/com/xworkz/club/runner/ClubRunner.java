package com.xworkz.club.runner;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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
		//		boolean save=clubDAO.save(clubEntity);
		//		System.out.println(save);
		//		System.out.println("*************************");
		//		boolean save1	=clubDAO.save(clubEntity1);
		//		System.out.println(save1);
		//		System.out.println("*************************");
		//		boolean save2=clubDAO.save(clubEntity2);
		//		System.out.println(save2);
		//
		//		System.out.println("*************************");
		//		ClubEntity entity=clubDAO.findById(2);
		//		System.out.println(entity);
		//
		//		System.out.println("*************************");
		//		clubDAO.updateCreatedByAndCreatedDateById("Manu", LocalDate.now(), 2);
		//
		//		System.out.println("*************************");
		//		clubDAO.deleteById(2);

		ClubEntity clubEntity3 = new ClubEntity(4, "xworkz", "BTM", LocalTime.of(12, 00), LocalTime.of(11, 00),
				"Honey", LocalDate.now(), "Ramu", LocalDate.now());
		ClubEntity clubEntity4 = new ClubEntity(5, "Yworkz", "HSR", LocalTime.of(12, 00), LocalTime.of(11, 00),
				"RaviRaj", LocalDate.now(), "Hanamant", LocalDate.now());
		List<ClubEntity> list=new ArrayList<ClubEntity>();
		list.add(clubEntity3);
		list.add(clubEntity4);
		boolean saves=clubDAO.saveAll(list);
		System.out.println(saves);






	}

}

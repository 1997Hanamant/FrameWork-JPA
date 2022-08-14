package com.xworkz.club.runner;

import com.xworkz.club.dao.ClubDAO;
import com.xworkz.club.dao.ClubDAOImpl;
import com.xworkz.club.entity.ClubEntity;

public class UtilRunner {

	public static void main(String[] args) {
		ClubDAO clubDAO = new ClubDAOImpl();
	ClubEntity clubEntity=clubDAO.findByName("Magala");
	System.out.println(clubEntity);

	}

}

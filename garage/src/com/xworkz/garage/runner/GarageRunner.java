package com.xworkz.garage.runner;

import java.time.LocalDate;
import java.time.LocalTime;

import com.xworkz.garage.dao.GarageDAO;
import com.xworkz.garage.dao.GarageDAOImpl;
import com.xworkz.garage.entity.GarageEntity;

public class GarageRunner {
	public static void main(String[] args) {
		GarageEntity garageEntity = new GarageEntity(3, "Laxmi Garage", "Ramdurga", LocalTime.of(10, 00),
				LocalTime.of(5, 00), "Manoj", LocalDate.of(2014, 01, 07), "Ragavendra", LocalDate.of(2021, 05, 07));
		GarageDAO garageDAO=new GarageDAOImpl();
		boolean	save=garageDAO.save(garageEntity);
		System.out.println(save);

		System.out.println("***********************");
		GarageEntity entity	=garageDAO.findById(3);
		System.out.println(entity);
		
		System.out.println("***********************");
		garageDAO.updateLocationById("Hubli", 2);
		
		System.out.println("***********************");
		garageDAO.deleteById(3);
		
	}

}

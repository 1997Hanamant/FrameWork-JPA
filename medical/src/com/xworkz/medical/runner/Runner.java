package com.xworkz.medical.runner;

import java.time.LocalDate;
import java.time.LocalTime;

import com.xworkz.medical.dao.MedicalDAO;
import com.xworkz.medical.dao.MedicalDAOImpl;
import com.xworkz.medical.entity.MedicalEntity;

public class Runner {
	public static void main(String[] args) {

		MedicalEntity medicalEntity = new MedicalEntity(1, "Sai", "BTM 1st Stage", LocalTime.of(6, 00),
				LocalTime.of(10, 00), "Basuraj", LocalDate.of(2022, 06, 3), "Muttu", 20000D);

		MedicalEntity medicalEntity1 = new MedicalEntity(2, "Ramu", "BTM 2st Stage", LocalTime.of(6, 00),
				LocalTime.of(12, 00), "Raviraj", LocalDate.of(2022, 06, 3), "Mamu", 30000D);

		MedicalEntity medicalEntity2 = new MedicalEntity(3, "Sanju", "BTM 3rd Stage", LocalTime.of(6, 00),
				LocalTime.of(12, 00), "Manju", LocalDate.of(2022, 06, 3), "Mami", 25000D);


		MedicalDAO medicalDAO=new MedicalDAOImpl();
		System.out.println("**************************");
		boolean save=medicalDAO.save(medicalEntity);
		System.out.println(save);

		System.out.println("**************************");
		boolean save1	=medicalDAO.save(medicalEntity1);
		System.out.println(save1);

		System.out.println("*****************************");
		boolean save2=medicalDAO.save(medicalEntity2);
		System.out.println(save2);

		System.out.println("*****************************");
		MedicalEntity entity=medicalDAO.findById(2);
		System.out.println(entity);
		
		System.out.println("*****************************");
		medicalDAO.updateownerAndTotalCostById("Sudeep", 50000D, 2);
		
		System.out.println("*****************************");
		medicalDAO.deleteById(3);
		
		






	}
}

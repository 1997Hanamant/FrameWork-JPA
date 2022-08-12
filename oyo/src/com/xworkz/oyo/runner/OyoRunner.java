package com.xworkz.oyo.runner;

import java.time.LocalDate;
import java.time.LocalTime;

import com.xworkz.oyo.dao.OyoDAO;
import com.xworkz.oyo.dao.OyoDAOImpl;
import com.xworkz.oyo.entity.OyoEntity;

public class OyoRunner {

	public static void main(String[] args) {
		OyoEntity oyoEntity = new OyoEntity(1, "Exotical hotel", "Basavangudi", LocalTime.of(10, 00),
				LocalTime.of(10, 00), "Charana", LocalDate.of(2020, 06, 03), "Kerthi", 1000D);

		OyoEntity oyoEntity1 = new OyoEntity(3, "Flagship ", "RR Nagar", LocalTime.of(10, 00),
				LocalTime.of(10, 00), "Manu", LocalDate.of(2021, 06, 01), "Netra", 800D);

		OyoDAO oyoDAO=new OyoDAOImpl();
		//System.out.println("*********************");
		//	boolean save=oyoDAO.save(oyoEntity);
		//System.out.println(save);

		//System.out.println("*********************");
		//boolean save1=oyoDAO.save(oyoEntity1);
		//	System.out.println(save1);

		//	System.out.println("*********************");
		//boolean save2=oyoDAO.save(oyoEntity1);
		//	System.out.println(save2);

		//System.out.println("*********************");
		//OyoEntity entity=oyoDAO.findById(2);
		//System.out.println(entity);
		
		System.out.println("*********************");
		oyoDAO.updatepricePerDayAndOwnerById(1500D, "Maltesh", 2);
		
		System.out.println("*********************");
		oyoDAO.deleteById(1);
		

	}

}

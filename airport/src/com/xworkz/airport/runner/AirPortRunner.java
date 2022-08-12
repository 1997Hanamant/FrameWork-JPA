package com.xworkz.airport.runner;

import java.time.LocalDate;

import com.xworkz.airport.dao.AirPortDAO;
import com.xworkz.airport.dao.AirPortDAOImpl;
import com.xworkz.airport.entity.AirPortEntity;

public class AirPortRunner {

	public static void main(String[] args) {
		AirPortEntity airPortEntity = new AirPortEntity(4, "Guru Ram Dass Jee International Airport, Amritsar",
				"Amritsar", "International", "400Acres", "Dharashan", LocalDate.of(1975, 02, 01), "Umesh",
				LocalDate.of(2015, 02, 05));
		AirPortDAO airPortDAO = new AirPortDAOImpl();
		airPortDAO.save(airPortEntity);

		AirPortEntity entity=airPortDAO.findById(1);
		System.out.println(entity);
		
		airPortDAO.updateNameAndLocationById("Kozhikode Airport, Calicut", "Calicut", 1);
		
		airPortDAO.deleteById(2);

	}

}

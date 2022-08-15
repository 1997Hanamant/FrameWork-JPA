package com.xworkz.freedomfighter.runner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.xworkz.freedomfighter.dao.FreedomFighterDAO;
import com.xworkz.freedomfighter.dao.FreedomFighterDAOImpl;
import com.xworkz.freedomfighter.entity.FreedomFighterEntity;

public class FFRunner {

	public static void main(String[] args) {
		FreedomFighterEntity freedomFighterEntity = new FreedomFighterEntity(1, "SangoliRayanna", LocalDate.now(),
				LocalDate.now(), "Male", "Chitrudurga", "Hanamant", LocalDate.now(), "Srinivas", LocalDate.now());
		FreedomFighterDAO freedomFighterDAO = new FreedomFighterDAOImpl();
		//boolean save = freedomFighterDAO.save(freedomFighterEntity);
		//System.out.println(save);

		FreedomFighterEntity freedomFighterEntity1 = new FreedomFighterEntity(2, "Sinduru Laxman", LocalDate.now(),
				LocalDate.now(), "Male", "Badami", "Hanamant", LocalDate.now(), "Nair", LocalDate.now());

		FreedomFighterEntity freedomFighterEntity2 = new FreedomFighterEntity(3, "Jansi Rani laxmi", LocalDate.now(),
				LocalDate.now(), "female", "ChitdruDruga", "Hanamant", LocalDate.now(), "Shivkumar", LocalDate.now());
		List<FreedomFighterEntity> list=new ArrayList<FreedomFighterEntity>();
		list.add(freedomFighterEntity1);
		list.add(freedomFighterEntity2);
		boolean save2=freedomFighterDAO.saveAll(list);
		System.out.println(save2);
	}

}

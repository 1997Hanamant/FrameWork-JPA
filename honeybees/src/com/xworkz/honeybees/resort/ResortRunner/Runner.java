package com.xworkz.honeybees.resort.ResortRunner;

import java.time.LocalDate;
import java.time.LocalTime;

import com.xworkz.honeybees.resort.dao.ResortDAO;
import com.xworkz.honeybees.resort.dao.ResortDAOImpl;
import com.xworkz.honeybees.resort.entity.ResortEntity;

public class Runner {

	public static void main(String[] args) {
		ResortEntity resortEntity = new ResortEntity();
		resortEntity.setId(1);
		resortEntity.setName("Pavitra Resort");
		resortEntity.setLocation("Hubli");
		resortEntity.setCheckInTime(LocalTime.of(12, 00));
		resortEntity.setCheckOutTime(LocalTime.of(11, 00));
		resortEntity.setCreateBy("Hanamant");
		resortEntity.setCreateDate(LocalDate.now());
		resortEntity.setUpdateDate(LocalDate.now());
		resortEntity.setPricePerDay(50000D);
		resortEntity.setOwner("Pavitra");

		ResortDAO resortDAO = new ResortDAOImpl();
		Boolean saved = resortDAO.save(resortEntity);
		System.out.println(saved);

	}

}

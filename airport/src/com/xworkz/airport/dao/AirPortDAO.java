package com.xworkz.airport.dao;

import com.xworkz.airport.entity.AirPortEntity;

public interface AirPortDAO {
	boolean save(AirPortEntity airPortEntity);
	AirPortEntity findById(int id);
	void updateNameAndLocationById(String newName,String newlocation,int id);
	void deleteById(int id);

}

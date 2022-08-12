package com.xworkz.garage.dao;

import com.xworkz.garage.entity.GarageEntity;

public interface GarageDAO {
	boolean save(GarageEntity entity);
	GarageEntity findById(int id);
	void updateLocationById(String newLocation, int id);
	void deleteById(int id);

}

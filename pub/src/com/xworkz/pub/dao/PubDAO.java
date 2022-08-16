package com.xworkz.pub.dao;

import java.util.List;

import com.xworkz.pub.entity.PubEntity;

public interface PubDAO {
	boolean save(PubEntity pubEntity);
	PubEntity findById(int id);
	void updateNameAndLocationByID(String newname,String newLocation,int id);
	void deleteById(int id);
	default PubEntity findByName(String name) {
		return null;
		
	}
	default PubEntity findByNameAndLocation(String name,String location) {
		return null;
		
	}
	default boolean saveAll(List<PubEntity> pubEntities) {
		return false;
	}
	
}

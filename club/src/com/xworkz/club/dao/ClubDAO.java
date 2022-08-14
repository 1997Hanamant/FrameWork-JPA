package com.xworkz.club.dao;

import java.time.LocalDate;

import com.xworkz.club.entity.ClubEntity;

public interface ClubDAO {
	boolean save(ClubEntity clubEntity);
	ClubEntity findById(Integer id);
	void updateCreatedByAndCreatedDateById(String newCreatedBy,LocalDate newCreatedDate,int id);
	void deleteById(Integer id);
	default ClubEntity findByName(String name) {
		return null;
	}
	default ClubEntity findByNameAndLocation(String name,String location) {
		return null;
		
	}

}

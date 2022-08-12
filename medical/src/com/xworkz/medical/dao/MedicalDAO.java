package com.xworkz.medical.dao;

import com.xworkz.medical.entity.MedicalEntity;

public interface MedicalDAO {
	boolean save (MedicalEntity medicalEntity);
	MedicalEntity findById(Integer id);
	void updateownerAndTotalCostById(String newOwner,Double newTotalCost,Integer id);
	void deleteById(Integer id);
	

}

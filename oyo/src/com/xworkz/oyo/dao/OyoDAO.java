package com.xworkz.oyo.dao;

import com.xworkz.oyo.entity.OyoEntity;

public interface OyoDAO {
	boolean save(OyoEntity oyoEntity);
	OyoEntity findById(int id);
	void updatepricePerDayAndOwnerById(Double newPerpricePerDay,String newOwner,int id);
	void deleteById(int id);

}

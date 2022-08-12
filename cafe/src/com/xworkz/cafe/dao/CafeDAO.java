package com.xworkz.cafe.dao;

import com.xworkz.cafe.entity.CafeEntity;

public interface CafeDAO {
	boolean save(CafeEntity cafeEntity);
	CafeEntity findById(int id);
	void updateNameById(String name,int id);
	void deleteById(int id);
	

}

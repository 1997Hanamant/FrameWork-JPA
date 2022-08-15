package com.xworkz.freedomfighter.dao;

import java.util.List;

import com.xworkz.freedomfighter.entity.FreedomFighterEntity;

public interface FreedomFighterDAO {
	boolean save(FreedomFighterEntity freedomFighterEntity);
	default boolean saveAll(List<FreedomFighterEntity> entities) {
		return false;
		
	}

}

package com.xworkz.markets.dao;

import com.xworkz.markets.entity.MarketEntity;

public interface MarketDAO {
	boolean saveAndValidate(MarketEntity marketEntity);

}

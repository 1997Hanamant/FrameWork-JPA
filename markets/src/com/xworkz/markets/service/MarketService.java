package com.xworkz.markets.service;

import com.xworkz.markets.entity.MarketEntity;

public interface MarketService {
	boolean saveAndValidate(MarketEntity marketEntity);

}

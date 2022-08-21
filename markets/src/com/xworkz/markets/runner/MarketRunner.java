package com.xworkz.markets.runner;

import java.time.LocalDate;

import com.xworkz.markets.entity.MarketEntity;
import com.xworkz.markets.service.MarketService;
import com.xworkz.markets.service.MarketServiceImpl;

public class MarketRunner {

	public static void main(String[] args) {
		MarketEntity marketEntity = new MarketEntity();
		marketEntity.setId(1);
		marketEntity.setName("Banshankari Market");
		marketEntity.setEstablishedDate(LocalDate.now());
		marketEntity.setCapacity(1500.00D);
		marketEntity.setLocation("BTM");
		marketEntity.setCreatedBy("Hanamant");
		marketEntity.setCreatedDate(LocalDate.now());
		marketEntity.setUpdatedBy("Hanamant");
		marketEntity.setUpdatedDate(LocalDate.now());

		// MarketDAO dao=new MarketDAOImpl();
		MarketService service = new MarketServiceImpl();
		service.saveAndValidate(marketEntity);

	}

}

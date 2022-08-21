package com.xworkz.markets.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import com.xworkz.markets.entity.MarketEntity;
import static com.xworkz.markets.util.EMFUtil.*;
public class MarketDAOImpl implements MarketDAO {
	EntityManagerFactory factory=getFactory();

	@Override
	public boolean saveAndValidate(MarketEntity marketEntity) {
		EntityManager manager = null;
		try {
			manager	=factory.createEntityManager();
			EntityTransaction entityTransaction	=manager.getTransaction();
			entityTransaction.begin();
			manager.persist(marketEntity);
			entityTransaction.commit();

		} catch (PersistenceException e) {
			e.printStackTrace();

		} finally {
			manager.close();

		}
		return false;
	}

}

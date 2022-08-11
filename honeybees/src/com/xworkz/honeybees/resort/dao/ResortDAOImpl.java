package com.xworkz.honeybees.resort.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.xworkz.honeybees.resort.entity.ResortEntity;

public class ResortDAOImpl implements ResortDAO {

	@Override
	public boolean save(ResortEntity resortEntity) {
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.xworkz");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction tx = manager.getTransaction();
			tx.begin();
			manager.persist(resortEntity);
			tx.commit();
			manager.close();
			factory.close();

		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return true;
	}

}

package com.xworkz.freedomfighter.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import com.xworkz.freedomfighter.entity.FreedomFighterEntity;
import static com.xworkz.freedomfighter.util.EMFUtil.*;

import java.util.List;

public class FreedomFighterDAOImpl implements FreedomFighterDAO {
	EntityManagerFactory factory = getFactory();

	@Override
	public boolean save(FreedomFighterEntity freedomFighterEntity) {
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			EntityTransaction entityTransaction = manager.getTransaction();
			entityTransaction.begin();
			manager.persist(freedomFighterEntity);
			entityTransaction.commit();

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			manager.close();

		}
		return true;
	}

	@Override
	public boolean saveAll(List<FreedomFighterEntity> entities) {
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			EntityTransaction entityTransaction = manager.getTransaction();
			entityTransaction.begin();
			for (FreedomFighterEntity fighterEntity : entities) {
				manager.persist(fighterEntity);
				// System.out.println(fighterEntity)
			}
			entityTransaction.commit();

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return FreedomFighterDAO.super.saveAll(entities);
	}
}

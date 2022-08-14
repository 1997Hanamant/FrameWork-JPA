package com.xworkz.cafe.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.xworkz.cafe.entity.CafeEntity;
import static com.xworkz.cafe.util.EMFUtil.*;

public class CafeDAOImpl implements CafeDAO{
	EntityManagerFactory factory=getFactory();

	@Override
	public boolean save(CafeEntity cafeEntity) {
		EntityManager manager=null;
		try {
			manager=factory.createEntityManager();
			EntityTransaction entityTransaction=manager.getTransaction();
			entityTransaction.begin();
			manager.persist(cafeEntity);
			entityTransaction.commit();
		}
		catch (PersistenceException e) {
			e.printStackTrace();
		}
		finally {
			manager.close();

		}
		return false;
	}

	@Override
	public CafeEntity findById(int id) {
		EntityManager manager=null;
		try {
			manager=factory.createEntityManager();
			CafeEntity entity=manager.find(CafeEntity.class, id);
			return entity;

		}
		catch (PersistenceException e) {
			e.printStackTrace();
		}
		finally {
			manager.close();
		}
		return null;
	}

	@Override
	public void updateNameById(String name, int id) {
		EntityManager manager=null;
		try {
			manager=factory.createEntityManager();
			EntityTransaction entityTransaction	=manager.getTransaction();
			entityTransaction.begin();
			CafeEntity entity=manager.find(CafeEntity.class, id);
			entity.setName(name);
			manager.merge(entity);
			System.out.println(entity );
			entityTransaction.commit();

		}
		catch (PersistenceException e) {
			e.printStackTrace();
		}
		finally {
			manager.close();

		}

	}

	@Override
	public void deleteById(int id) {
		EntityManager manager=null;
		try {
			manager=factory.createEntityManager();
			EntityTransaction entityTransaction	=manager.getTransaction();
			entityTransaction.begin();
			CafeEntity entity=manager.find(CafeEntity.class, id);
			manager.remove(entity);
			System.out.println(entity );
			entityTransaction.commit();

		}
		catch (PersistenceException e) {
			e.printStackTrace();
		}
		finally {
			manager.close();

		}

	}

}

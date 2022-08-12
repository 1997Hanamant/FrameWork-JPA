package com.xworkz.garage.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.xworkz.garage.entity.GarageEntity;

public class GarageDAOImpl implements GarageDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.xworkz");
	EntityManager manager = null;

	@Override
	public boolean save(GarageEntity garageEntity) {
		try {
			manager = factory.createEntityManager();
			EntityTransaction entityTransaction = manager.getTransaction();
			entityTransaction.begin();
			manager.persist(garageEntity);
			entityTransaction.commit();

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			manager.close();

		}
		return true;
	}

	@Override
	public GarageEntity findById(int id) {
		try {
			manager = factory.createEntityManager();
			GarageEntity entity = manager.find(GarageEntity.class, id);
			if(entity!=null) {
				System.out.println("Table is found:"+id);
				return entity;
			}
			else {
				System.out.println("Table is not found");
			}

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			manager.close();

		}
		return null;
	}

	@Override
	public void updateLocationById(String newLocation, int id) {
		try {
			manager=factory.createEntityManager();
			EntityTransaction entityTransaction	=manager.getTransaction();
			entityTransaction.begin();
			GarageEntity entity	=manager.find(GarageEntity.class, id);
			entity.setLocation("Hubli");
			System.out.println(entity);
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
		try {
			manager=factory.createEntityManager();
			EntityTransaction entityTransaction	=manager.getTransaction();
			entityTransaction.begin();
			GarageEntity entity	=manager.find(GarageEntity.class, id);
			manager.remove(entity);
			System.out.println(entity);
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

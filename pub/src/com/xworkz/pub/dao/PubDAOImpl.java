package com.xworkz.pub.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.xworkz.pub.entity.PubEntity;

public class PubDAOImpl implements PubDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.xworkz");
	EntityManager manager=null;

	@Override
	public boolean save(PubEntity pubEntity) {
		try {
			 manager = factory.createEntityManager();
			EntityTransaction tx = manager.getTransaction();
			tx.begin();
			manager.persist(pubEntity);
			tx.commit();
	
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return true;
	}

	@Override
	public PubEntity findById(int id) {
		try {
			manager=factory.createEntityManager();
			PubEntity entity = manager.find(PubEntity.class, id);
			if (entity != null) {
				System.out.println("entity table is found:" + id);
				return entity;

			} else {
				System.out.println("entity table is not found");

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();

		}
		return null;
	}

	@Override
	public void updateNameAndLocationByID(String newname, String newLocation, int id) {
		try {
			 manager = factory.createEntityManager();
				EntityTransaction tx = manager.getTransaction();
				tx.begin();
			PubEntity entity = manager.find(PubEntity.class, id);
			if (entity != null) {
				System.out.println("Entity Table is found:" + id);

				entity.setName(newname);
				entity.setLocation(newLocation);
				manager.merge(entity);
				System.out.println(entity);

			} else {
				System.out.println("Table is not found");
			}
			tx.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			manager.close();

		}
	}

	@Override
	public void deleteById( int id) {
		try {
			 manager = factory.createEntityManager();
			EntityTransaction tx = manager.getTransaction();
			tx.begin();
			PubEntity entity = manager.find(PubEntity.class, id);
			if (entity != null) {
				System.out.println("Entity table is found:" + id);
				manager.remove(entity);
			} else {
				System.out.println("Entity table is not");
			}
			tx.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			manager.close();

		}
	}

}

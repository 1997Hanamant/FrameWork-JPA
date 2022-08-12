package com.xworkz.club.dao;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.xworkz.club.entity.ClubEntity;

public class ClubDAOImpl implements ClubDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.xworkz");
	EntityManager manager = null;

	@Override
	public boolean save(ClubEntity clubEntity) {
		try {
			manager = factory.createEntityManager();
			EntityTransaction tx = manager.getTransaction();
			tx.begin();
			manager.persist(clubEntity);
			tx.commit();

		} catch (PersistenceException e) {
			e.printStackTrace();

		} finally {
			manager.close();
		}
		return true;
	}

	@Override
	public ClubEntity findById(Integer id) {
		try {
			manager = factory.createEntityManager();
			ClubEntity entity = manager.find(ClubEntity.class, id);
			if (entity != null) {
				System.out.println("Entity table is found:" + id);
				return entity;
			} else {
				System.out.println("Entity table is not found");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();

		}
		return null;
	}

	@Override
	public void updateCreatedByAndCreatedDateById(String newCreatedBy, LocalDate newCreatedDate, int id) {
		try {
			manager = factory.createEntityManager();
			EntityTransaction entityTransaction = manager.getTransaction();
			entityTransaction.begin();
			ClubEntity entity = manager.find(ClubEntity.class, id);
			if (entity != null) {
				System.out.println("Entity table is found:" + id);
				entity.setCreatedBy(newCreatedBy);
				entity.setCreatedDate(newCreatedDate);
				manager.merge(entity);
				System.out.println(entity);
			} else {
				System.out.println("Entity table is not found");
			}
			entityTransaction.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			manager.close();

		}

	}

	@Override
	public void deleteById(Integer id) {
		try {
			manager = factory.createEntityManager();
			EntityTransaction entityTransaction = manager.getTransaction();
			entityTransaction.begin();
			ClubEntity entity = manager.find(ClubEntity.class, id);
			if (entity != null) {
				System.out.println("Entity table is found :" + id);
				manager.remove(entity);
			} else {
				System.out.println("Entity table is not found");
			}
			entityTransaction.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			manager.close();

		}
	}

}

package com.xworkz.club.dao;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import static com.xworkz.club.util.EMFUtil.*;

import com.xworkz.club.entity.ClubEntity;

public class ClubDAOImpl implements ClubDAO {
	EntityManagerFactory factory = getFactory();

	@Override
	public boolean save(ClubEntity clubEntity) {
		EntityManager manager = null;

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
		EntityManager manager = null;
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
		EntityManager manager = null;
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
		EntityManager manager = null;
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

	@Override
	public ClubEntity findByName(String name) {
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			Query query = manager.createNamedQuery("findByName");
			query.setParameter("nm", name);
			Object object = query.getSingleResult();
			if (object != null) {
				System.out.println(("Name is found"));
				ClubEntity clubEntity = (ClubEntity) object;
				return clubEntity;
			} else {
				System.out.println("Name is not found");
			}

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return ClubDAO.super.findByName(name);
	}

	@Override
	public ClubEntity findByNameAndLocation(String name, String location) {
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			Query query = manager.createNamedQuery("findByNameAndLocation");
			Object object = query.getSingleResult();
			if (object != null) {
				System.out.println("NameAndLocation are found");
				ClubEntity clubEntity = (ClubEntity) object;
				return clubEntity;
			} else {
				System.out.println("NameAndLocation are not found");
			}

		} catch (PersistenceException e) {
		} finally {
			manager.close();
		}

		return ClubDAO.super.findByNameAndLocation(name, location);
	}
}

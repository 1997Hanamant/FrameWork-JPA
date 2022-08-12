package com.xworkz.medical.dao;

import java.awt.image.AbstractMultiResolutionImage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.xworkz.medical.entity.MedicalEntity;

public class MedicalDAOImpl implements MedicalDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.xworkz");
	EntityManager manager = null;

	@Override
	public boolean save(MedicalEntity medicalEntity) {
		try {
			manager = factory.createEntityManager();
			EntityTransaction entityTransaction = manager.getTransaction();
			entityTransaction.begin();
			manager.persist(medicalEntity);
			entityTransaction.commit();

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			manager.close();

		}
		return true;
	}

	@Override
	public MedicalEntity findById(Integer id) {
		try {
			manager = factory.createEntityManager();
			MedicalEntity entity = manager.find(MedicalEntity.class, id);
			if (entity != null) {
				System.out.println("Entity table is found:" + id);
				return entity;
			} else {
				System.out.println("Table entity is not found");
			}

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return null;
	}

	@Override
	public void updateownerAndTotalCostById(String newOwner, Double newTotalCost, Integer id) {
		try {
			manager = factory.createEntityManager();
			EntityTransaction entityTransaction = manager.getTransaction();
			entityTransaction.begin();
			MedicalEntity entity = manager.find(MedicalEntity.class, id);
			if(entity!=null) {
				System.out.println("Entity table is found:"+id);
				entity.setOwner(newOwner);
				entity.setTotalCost(newTotalCost);
				manager.merge(entity);
				System.out.println(entity);
			}
			else {
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
			manager=factory.createEntityManager();
			EntityTransaction entityTransaction	=manager.getTransaction();
			entityTransaction.begin();
			MedicalEntity entity=manager.find(MedicalEntity.class, id);
			if(entity!=null) {
				System.out.println("Entity table is found:"+id);
				manager.remove(entity);
			}
			else {
				System.out.println("Entity table is not found");
			}

		}
		catch (PersistenceException e) {
			e.printStackTrace();
		}
		finally {
			manager.close();
		}

	}

}

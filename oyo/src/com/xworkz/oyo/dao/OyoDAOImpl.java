package com.xworkz.oyo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import com.xworkz.oyo.entity.OyoEntity;
import static com.xworkz.oyo.util.EMFUtil.*;

public class OyoDAOImpl implements OyoDAO {
	EntityManagerFactory factory=getFactory();

	@Override
	public boolean save(OyoEntity oyoEntity) {
		EntityManager manager=null;
		try {
			manager=factory.createEntityManager();
			EntityTransaction entityTransaction	= manager.getTransaction();
			entityTransaction.begin();
			manager.persist(oyoEntity);
			entityTransaction.commit();
		}
		catch (PersistenceException e) {
			e.printStackTrace();
		}
		finally {
			manager.close();

		}
		return true;
	}

	@Override
	public OyoEntity findById(int id) {
	EntityManager manager=null;
		try {
			manager=factory.createEntityManager();
			OyoEntity entity=manager.find(OyoEntity.class,id);
			if(entity!=null) {
				System.out.println("Entity table is found:"+id);
				return entity;
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
		return null;
	}

	@Override
	public void updatepricePerDayAndOwnerById(Double newPerpricePerDay, String newOwner, int id) {
	EntityManager manager=null;
		try {
			manager=factory.createEntityManager();
			EntityTransaction entityTransaction	=manager.getTransaction();
			entityTransaction.begin();
			OyoEntity entity=manager.find(OyoEntity.class, id);
			if(entity!=null) {
				System.out.println("Entity table is found:"+id);
				entity.setPerPerDay(newPerpricePerDay);
				entity.setOwner(newOwner);
				manager.merge(entity);
			}
			else {
				System.out.println("Entity table is not found");
			}
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
			OyoEntity entity=manager.find(OyoEntity.class, id);
			if(entity!=null) {
				System.out.println("Entity Table is found:"+id);
                manager.remove(entity);
			}
			else {
				System.out.println("Entity table is not found");
			}
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

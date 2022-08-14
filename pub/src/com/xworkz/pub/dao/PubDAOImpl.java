package com.xworkz.pub.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.xworkz.pub.entity.PubEntity;
import static com.xworkz.pub.util.EMFUtil.*;

public class PubDAOImpl implements PubDAO {
	EntityManagerFactory factory =getFactory();

	@Override
	public boolean save(PubEntity pubEntity) {
		EntityManager manager=null;
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
		EntityManager manager=null;
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
		EntityManager manager=null;
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
				System.err.println("Table is not found");
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
		EntityManager manager=null;
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
	@Override
	public PubEntity findByName(String name) {
		EntityManager manager=null;
		try {
			manager=factory.createEntityManager();
			Query query	=manager.createNamedQuery("findByName");
			query.setParameter("nm",name);
			Object object=query.getSingleResult();

			if(object!=null) {
				System.out.println("Name is found");
				PubEntity pubEntity=(PubEntity)object;
				return pubEntity;
			}
			else {
				System.out.println("Name is not found");
			}
		}
		catch (PersistenceException e) {
			e.printStackTrace();
		}
		finally {

		}

		return PubDAO.super.findByName(name);
	}
	@Override
	public PubEntity findByNameAndLocation(String name, String location) {
		EntityManager manager=null;
		try {
			manager=factory.createEntityManager();
			Query query	=manager.createNamedQuery("findByNameAndLocation");
			query.setParameter("nm", name);
			query.setParameter("loc", location);
			Object object=query.getSingleResult();
			if(object!=null) {
				System.out.println("findByNameAndLocation is found");
				PubEntity pubEntity=(PubEntity)object;
				return pubEntity;
			}

		}
		catch (PersistenceException e) {
			e.printStackTrace();
		}
		finally {
			manager.close();

		}
		return PubDAO.super.findByNameAndLocation(name, location);
	}
}

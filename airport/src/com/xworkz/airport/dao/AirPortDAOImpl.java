package com.xworkz.airport.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import com.xworkz.airport.entity.AirPortEntity;
import static com.xworkz.airport.util.EMFUtil.*;

public class AirPortDAOImpl implements AirPortDAO {
	EntityManagerFactory factory=getFactory();
	private	EntityManager manager=null;
	@Override
	public boolean save(AirPortEntity airPortEntity) {
		try {
			this.manager=factory.createEntityManager();
			EntityTransaction entityTransaction = manager.getTransaction();
			entityTransaction.begin();
			manager.persist(airPortEntity);
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
	public AirPortEntity findById(int id) {
		try {
			this.manager=factory.createEntityManager();
			AirPortEntity airPortEntity=manager.find(AirPortEntity.class, id);
			if(airPortEntity!=null) {
				System.out.println("Entity table is found:"+id);
				return airPortEntity;
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
	public void updateNameAndLocationById(String newName, String newlocation, int id) {
		try {
			manager=factory.createEntityManager();
			EntityTransaction entityTransaction	=manager.getTransaction();
			entityTransaction.begin();
			AirPortEntity entity=manager.find(AirPortEntity.class, id);
			if(entity!=null) {
				System.out.println("Entity table is found:"+id);
				entity.setName(newName);
				entity.setLocation(newlocation);
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
		try {
			manager=factory.createEntityManager();
			EntityTransaction entityTransaction	=manager.getTransaction();
			entityTransaction.begin();
			AirPortEntity entity=manager.find(AirPortEntity.class, id);
			if(entity!=null) {
				System.out.println("Entity table is found:"+id);
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

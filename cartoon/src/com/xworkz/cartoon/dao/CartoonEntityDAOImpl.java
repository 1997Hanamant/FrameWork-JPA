package com.xworkz.cartoon.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.xworkz.cartoon.entity.CartoonEntity;
import static com.xworkz.cartoon.util.EMFUtil.*;

public class CartoonEntityDAOImpl implements CartoonEntityDAO {
	EntityManagerFactory factory=getFactory();

	@Override
	public boolean saveAll(List<CartoonEntity> cartoonEntities) {
		EntityManager manager = null;
		try {
			manager	=factory.createEntityManager();
			EntityTransaction entityTransaction	=manager.getTransaction();
			entityTransaction.begin();
			manager.persist(cartoonEntities);
			entityTransaction.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();

		} finally {
			manager.close();

		}
		return false;
	}
	@Override
	public CartoonEntity findByName(String name) {
		EntityManager manager = null;
		try {
			manager	=factory.createEntityManager();
			Query query	=manager.createNamedQuery("findByName");
			query.setParameter("nm", name);
			Object object	=query.getSingleResult();
			if(object!=null) {			
				CartoonEntity cartoonEntity=(CartoonEntity)object;
				return cartoonEntity;
			}

		} catch (PersistenceException e) {
			e.printStackTrace();

		} finally {
			manager.close();

		}
		return CartoonEntityDAO.super.findByName(name);

	}
	@Override
	public CartoonEntity findByMaxCreatedDate() {
		EntityManager manager = null;
		try {
			manager	=factory.createEntityManager();
			Query query=manager.createNamedQuery("findByMaxCreatedDate");
			Object object=query.getSingleResult();
			if(object!=null)
			{
				Object[] array=(Object[])object;
				//System.out.println(array[0]);
				//System.out.println(array[1]);

				return (CartoonEntity)array[1];
			}
			System.out.println(object);

		} catch (PersistenceException e) {
			e.printStackTrace();

		} finally {
			manager.close();

		}
		return null;
	}
	@Override
	public CartoonEntity findByNameAndCountryAndGenderAndAuthor(String name, String country, String gender,
			String author) {
		EntityManager manager = null;
		try {
			manager	=factory.createEntityManager();
			Query query	=manager.createNamedQuery("findByNameAndCountryAndGenderAndAuthor");
			query.setParameter("ns", name);
			query.setParameter("cou", country);
			query.setParameter("gen", gender);
			query.setParameter("aut", author);
			Object object	=query.getSingleResult();
			if(object!=null) {
				CartoonEntity cartoonEntity=(CartoonEntity)object;
				return cartoonEntity;
			}

		} catch (PersistenceException e) {
			e.printStackTrace();

		} finally {
			manager.close();

		}
		return null;
	}
	@Override
	public String findAuthorByName(String name) {
		EntityManager manager = null;
		try {
			manager	=factory.createEntityManager();
			Query query	=manager.createNamedQuery("findAuthorByName");
			query.setParameter("nn", name);
			Object object	=query.getSingleResult();
			if(object!=null) {
				String string=(String)object;
				return string;
			}

		} catch (PersistenceException e) {
			e.printStackTrace();

		} finally {
			manager.close();

		}
		return null;
	}
	@Override
	public Object[] findNameAndCountryByAuthor(String author) {
		EntityManager manager = null;
		try {
			manager	=factory.createEntityManager();
			Query query	=manager.createNamedQuery("findNameAndCountryByAuthor");
			query.setParameter("ar", author);
			Object object	=query.getSingleResult();
			if(object!=null) {
				Object[] objects=(Object[])object;
				System.out.println(objects[0]);
				System.out.println((objects[1]));
			}

		} catch (PersistenceException e) {
			e.printStackTrace();

		} finally {
			manager.close();

		}
		return null;
	}
	@Override
	public LocalDateTime findCreatedDateByAuthor(String author) {
		EntityManager manager = null;
		try {
			manager	=factory.createEntityManager();
			Query query	=manager.createNamedQuery( "findCreatedDateByAuthor");
			query.setParameter("ah", author);
			Object object=query.getSingleResult();
			System.out.println(object);
			if(object!=null) {
				LocalDateTime localDateTime=(LocalDateTime)object;
				return localDateTime;
			}

		} catch (PersistenceException e) {
			e.printStackTrace();
			manager.getTransaction().rollback();

		} finally {
			manager.close();

		}
		return null;
	}


	@Override
	public Integer total() {
		EntityManager manager = null;
		try {
			manager=factory.createEntityManager();
			Query query	=manager.createNamedQuery("total");
			Object object=query.getSingleResult();
			System.out.println(object);


		} catch (PersistenceException e) {
			e.printStackTrace();

		} finally {
			manager.close();

		}

		return null;
	}

	@Override
	public void updateAuthorByName(String author, String name) {
		EntityManager manager = null;
		try {
			manager	=factory.createEntityManager();
			EntityTransaction entityTransaction	=manager.getTransaction();
			entityTransaction.begin();
			Query query	=manager.createNamedQuery("updateAuthorByName");
			query.setParameter("tr", author);
			query.setParameter("as", name);
			query.executeUpdate();
			System.out.println("The Updated Author Name is:"+ author);
			//			Object object	=query.getSingleResult();
			//			if(object!=null) {
			//				System.out.println(object);
			//			}
			entityTransaction.commit();

		} catch (PersistenceException e) {
			e.printStackTrace();

		} finally {
			manager.close();

		}

	}
	@Override
	public void updateTypeByName(String type, String name) {
		EntityManager manager = null;
		try {
			manager	=factory.createEntityManager();
			EntityTransaction entityTransaction	=manager.getTransaction();
			entityTransaction.begin();
			Query query	=manager.createNamedQuery("updateTypeByName");
			query.setParameter("ty", type);
			query.setParameter("ao", name);
			query.executeUpdate();
			System.out.println("updated type is :"+type);
			//			Object object	=query.getSingleResult();
			//			if(object!=null) {
			//				System.out.println(object);
			//			}
			entityTransaction.commit();

		} catch (PersistenceException e) {
			e.printStackTrace();

		} finally {
			manager.close();
		}

	}
	@Override
	public void deleteByName(String name) {
		EntityManager manager = null;
		try {
			manager	=factory.createEntityManager();
			EntityTransaction entityTransaction	=manager.getTransaction();
			entityTransaction.begin();
			Query query	=manager.createNamedQuery("deleteByName");
			query.setParameter("hs", name);
			query.executeUpdate();
			System.out.println("deleted name is:"+name);
			//			if(object!=null) {
			//				System.out.println(object);
			//			}
			entityTransaction.commit();

		} catch (PersistenceException e) {
			e.printStackTrace();

		} finally {
			manager.close();

		}
	}
	@Override
	public List<CartoonEntity> findAll() {
		EntityManager manager = null;
		try {
			manager	=factory.createEntityManager();
			Query query	=manager.createNamedQuery("findAll");
			List<CartoonEntity>	list=query.getResultList();
			return list;
		} catch (PersistenceException e) {
			e.printStackTrace();

		} finally {
			manager.close();

		}
		return CartoonEntityDAO.super.findAll();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<CartoonEntity> findAllByAuthor(String author) {
		EntityManager manager = null;
		try {
			manager	=factory.createEntityManager();
			Query query	=manager.createNamedQuery("findAllByAuthor");
			query.setParameter("ax", author);
			List<CartoonEntity>	list=query.getResultList();
			return list;

		} catch (PersistenceException e) {
			e.printStackTrace();

		} finally {
			manager.close();

		}
		return CartoonEntityDAO.super.findAllByAuthor(author);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<CartoonEntity> findAllByAuthorAndGender(String author, String gender) {
		EntityManager manager = null;
		try {
			manager	=factory.createEntityManager();
			Query query	=manager.createNamedQuery("findAllByAuthorAndGender");
			query.setParameter("az",author );
			query.setParameter("ge", gender );
			List<CartoonEntity>	list=query.getResultList();
			if(list!=null) {
				return list;

			}

		} catch (PersistenceException e) {
			e.printStackTrace();

		} finally {
			manager.close();

		}
		return CartoonEntityDAO.super.findAllByAuthorAndGender(author, gender);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<String> findAllName() {
		EntityManager manager = null;
		try {
			manager	=factory.createEntityManager();
			Query query	=manager.createNamedQuery("findAllName");
			List<String > list	=query.getResultList();
			if(list!=null) {
				return list;
			}
		} catch (PersistenceException e) {
			e.printStackTrace();

		} finally {
			manager.close();

		}
		return CartoonEntityDAO.super.findAllName();
	}
	@Override
	public List<String> findAllCountry() {
		EntityManager manager = null;
		try {
			manager=factory.createEntityManager();
			Query query	=manager.createNamedQuery("findAllCountry");
			List<String> list=query.getResultList();
			if(list!=null) {
				return list;
			}

		} catch (PersistenceException e) {
			e.printStackTrace();

		} finally {
			manager.close();

		}
		return CartoonEntityDAO.super.findAllCountry();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findAllNameAndCountry() {
		EntityManager manager = null;
		try {
			manager	=factory.createEntityManager();
			Query query	=manager.createNamedQuery("findAllNameAndCountry");
			List<Object[]> list=query.getResultList();
			return list;


		} catch (PersistenceException e) {
			e.printStackTrace();

		} finally {
			manager.close();

		}
		return CartoonEntityDAO.super.findAllNameAndCountry();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findAllNameAndCountryAndAuthor() {
		EntityManager manager = null;
		try {
			manager	=factory.createEntityManager();
			Query query	=manager.createNamedQuery("findAllNameAndCountryAndAuthor");
			List<Object[]> list=query.getResultList();
			if(list!=null) {
				return list;
			}

		} catch (PersistenceException e) {
			e.printStackTrace();

		} finally {
			manager.close();

		}
		return CartoonEntityDAO.super.findAllNameAndCountryAndAuthor();
	}
}
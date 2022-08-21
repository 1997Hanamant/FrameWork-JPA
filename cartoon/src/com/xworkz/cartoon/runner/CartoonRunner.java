package com.xworkz.cartoon.runner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.xworkz.cartoon.dao.CartoonEntityDAO;
import com.xworkz.cartoon.dao.CartoonEntityDAOImpl;
import com.xworkz.cartoon.entity.CartoonEntity;
import com.xworkz.cartoon.service.CartoonService;
import com.xworkz.cartoon.service.CartoonServiceImpl;

public class CartoonRunner {

	public static void main(String[] args) {
		CartoonEntity cartoonEntity = new CartoonEntity( "Betty Boop", "India", "male", "Hanamant", "Comdey", "Hanamant",
				LocalDate.now(), "Hanamant", LocalDate.now());

		CartoonEntity cartoonEntity1 = new CartoonEntity("Bugs Bunny", "India", "female", "Arjun", "Comdey", "Hanamant",
				LocalDate.now(), "Arjun", LocalDate.now());

		CartoonEntity cartoonEntity2 = new CartoonEntity("Charlie Brown", "USA", "female", "Chandru", "fight",
				"Hanamant", LocalDate.now(), "chandru", LocalDate.now());

		CartoonEntity cartoonEntity3 = new CartoonEntity("Daffy Duck", "USA", "male", "Dharsan", "fight", "Hanamant",
				LocalDate.now(), "Dharasn", LocalDate.now());

		CartoonEntity cartoonEntity4 = new CartoonEntity("Dennis the Menace", "Canada", "male", "Sachin", "Comdey",
				"Hanamant", LocalDate.now(), "Sachin", LocalDate.now());

		CartoonEntity cartoonEntity5 = new CartoonEntity("Donald Duck", "Aus", "male", "Sharat", "Comdey", "Hanamant",
				LocalDate.now(), "Sharat", LocalDate.now());

		CartoonEntity cartoonEntity6 = new CartoonEntity("Garfield", "Nz", "female", "Nandna", "fight", "Hanamant",
				LocalDate.now(), "Nandna", LocalDate.now());

		CartoonEntity cartoonEntity7 = new CartoonEntity("Mickey Mouse", "West Indies", "male", "Nandesh", "fight",
				"Hanamant", LocalDate.now(), "Nandesh", LocalDate.now());

		CartoonEntity cartoonEntity8 = new CartoonEntity("Popeye", "Germany", "male", "Suhas", "fight", "Hanamant",
				LocalDate.now(), "Suhas", LocalDate.now());

		CartoonEntity cartoonEntity9 = new CartoonEntity("Road Runner", "Poland", "male", "Ramesh", "fight", "Hanamant",
				LocalDate.now(), "Ramesh", LocalDate.now());

		CartoonEntityDAO cartoonEntityDAO=new CartoonEntityDAOImpl();
		List<CartoonEntity> list=new ArrayList<CartoonEntity>();
		list.add(cartoonEntity);
		list.add(cartoonEntity1);
		list.add(cartoonEntity2);
		list.add(cartoonEntity3);
		list.add(cartoonEntity4);
		list.add(cartoonEntity5);
		list.add(cartoonEntity6);
		list.add(cartoonEntity7);
		list.add(cartoonEntity8);
		list.add(cartoonEntity9);
		CartoonService service=new CartoonServiceImpl();
		//	boolean save=service.validateAndSaveAll(list);
		//System.out.println(save);
		CartoonEntity entity=service.findByName("Road Runner");
		System.out.println(entity);

		//boolean save=cartoonEntityDAO.saveAll(list);
		//	System.out.println(save);

		//		CartoonEntity entity=cartoonEntityDAO.findByName("Daffy Duck");
		//		System.out.println(entity);
		//
		//		Integer total=cartoonEntityDAO.total();
		//		System.out.println(total);
		//
		//			CartoonEntity entity1=cartoonEntityDAO.findByNameAndCountryAndGenderAndAuthor("Garfield", "Nz", "female", "Nandna");
		//		  System.out.println(entity1);
		//
		//		String name=cartoonEntityDAO.findAuthorByName("Betty Boop");
		//		System.out.println(name);
		//
		//		Object[]objects=cartoonEntityDAO.findNameAndCountryByAuthor("Nandna");
		//		System.out.println(objects[0]);
		//			System.out.println(objects[1]);
		//
		//			LocalDateTime time=cartoonEntityDAO.findCreatedDateByAuthor("Sharat");
		//			System.out.println(time);
		//
		//		cartoonEntityDAO.updateAuthorByName("Charan", "Bugs Bunny");
		//			cartoonEntityDAO.updateTypeByName("Dance", "Bugs Bunny");
		//		cartoonEntityDAO.deleteByName("Garfield");
		//		CartoonEntity enCartoonEntity=cartoonEntityDAO.findByMaxCreatedDate();
		//		System.out.println(enCartoonEntity);
		//cartoonEntityDAO.findAll().forEach(System.out::println);

		//cartoonEntityDAO.findAllByAuthor("Charan").forEach(System.out::println);
		//cartoonEntityDAO.findAllByAuthorAndGender("Dharsan", "male").forEach(System.out::println);
		//cartoonEntityDAO.findAllName().forEach(System.out:: println);
		//cartoonEntityDAO.findAllCountry().forEach(System.out::println);
		//	List<Object> objects	=cartoonEntityDAO.findAllNameAndCountry();
		//System.out.println(objects.getClass().getName()+'@'+Integer.toHexString(0));

		//	cartoonEntityDAO.findAllNameAndCountry().forEach(obj->System.out.println(obj[0]+"::"+obj[1]));

		//	cartoonEntityDAO.findAllNameAndCountryAndAuthor().forEach(obj->System.out.println(obj[0]+"::"+obj[1]+"::"+obj[2]));






	}

}

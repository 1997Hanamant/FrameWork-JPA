package com.xworkz.pub.runner;

import com.xworkz.pub.dao.PubDAO;
import com.xworkz.pub.dao.PubDAOImpl;
import com.xworkz.pub.entity.PubEntity;

public class EMFRunner {

	public static void main(String[] args) {
		PubDAO pubDAO=new PubDAOImpl();
		PubEntity pubEntity	=pubDAO.findByName("Sujata");
		System.out.println(pubEntity);
		
		System.out.println("********************");
		
		PubEntity pubEntity2=pubDAO.findByNameAndLocation("mallavva", "BTM 3rdt Stage");
		System.out.println(pubEntity2);


	}

}

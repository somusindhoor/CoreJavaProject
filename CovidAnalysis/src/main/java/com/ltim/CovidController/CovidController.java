package com.ltim.CovidController;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ltim.CovidDaoImpl.CovidDaoImpl;
import com.ltim.exception.InvalidChoiceException;
import com.ltim.model.Coviddata;

public class CovidController {
public static void main(String[] args) {
	EntityManagerFactory  entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction =entityManager.getTransaction();
	
//	Coviddata data2=new Coviddata();
//	data2.setDate("2020-08-07");
//	data2.setState("JK");
//	data2.setDistrict("Kupwara");
//	data2.setTested(0);
//	data2.setConfirmed(28);
//	data2.setRecovered(6);

	
//	entityTransaction.begin();
//	entityManager.persist(data2);
//	entityTransaction.commit();
	
	Scanner sc = new Scanner(System.in);

	System.out.println("1:Get State Name \n2: Get District name for given states");
	System.out.println("3:Display Data by state with in data range\n4:Exit");
	System.out.println("Please select option : ");
	int option=sc.nextInt();
	
	
	switch(option) {
	case 1:
		EntityManagerFactory entityManagerFactory1 = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager1 = entityManagerFactory1.createEntityManager();

		Query query = entityManager1.createQuery("select state from coviddata ");
		List<Coviddata> coviddatas1 = query.getResultList();
		entityTransaction.begin();
     	entityManager.persist(coviddatas1);
		entityTransaction.commit();
		break;

	case 2:
		
		break;

	case 3:
		
		break;

	default:
		try {
			throw new InvalidChoiceException("Invalid Choice!");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
}

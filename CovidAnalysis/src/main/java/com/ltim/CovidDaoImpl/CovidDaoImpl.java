package com.ltim.CovidDaoImpl;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.ltim.CovidDao.CovidDao;
import com.ltim.model.Coviddata;


public class CovidDaoImpl implements CovidDao{

	public List<Coviddata> getstateNames() {
//		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
//		EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//		Query query = entityManager.createQuery("select state from covid_analysis ");
//		List<Coviddata> coviddatas = query.getResultList();
//		return coviddatas;
		
	}

	public List<Coviddata> getDistrictForgivenState() {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Query query = entityManager.createQuery("select district from coviddata  where state='JK'");
		List<Coviddata> coviddatas1 = query.getResultList();
		return coviddatas1;
		
		
	}

	public List<Coviddata> displayDataBystateWithInDateRange() {
		return null;
		
	}

}

package com.ltim.CovidDao;
import java.util.List;
import com.ltim.model.Coviddata;

public interface CovidDao {

	List<Coviddata> getstateNames();
	List<Coviddata> getDistrictForgivenState();
	List<Coviddata> displayDataBystateWithInDateRange();
	
}

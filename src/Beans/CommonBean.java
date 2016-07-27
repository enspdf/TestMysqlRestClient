package Beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entities.City;
import Entities.Country;
import Entities.Department;
import Requests.GetRequests;
import Requests.PostRequests;

@ManagedBean
@SessionScoped
public class CommonBean {

	GetRequests get = new GetRequests();
	PostRequests post = new PostRequests();
	
	public void addCountry(Country country) {
		if (country.getCountry_name().isEmpty() || country.getCountry_name() == null)
			System.out.println("The country name is required");
		else
			post.PostRequestCountry(country);
	}
	
	public void addDepartment(Department department) {
		if (department.getCountry_id() < 1)
			System.out.println("The country id is required");
		if (department.getDepartment_name().isEmpty() || department.getDepartment_name() == null)
			System.out.println("The country name is required");
		else
			post.PostRequestDepartment(department);
	}
	
	public void addCity(City city) {
		if (city.getDepartment_id() < 1)
			System.out.println("The department id is required");
		if (city.getCity_name().isEmpty() || city.getCity_name() == null)
			System.out.println("The department name is required");
		else
			post.PostRequestCity(city);
	}
	
}

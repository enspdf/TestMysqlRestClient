package Requests;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.util.MultivaluedMapImpl;

import Entities.City;
import Entities.Country;
import Entities.Department;
import Entities.User;

public class PostRequests {

	ClientConfig config = new DefaultClientConfig();
	Client client = Client.create(config);

	public void PostRequestUser(User user) {
		WebResource webResource = client.resource(
				UriBuilder.fromUri("http://localhost:8181/TestMysqlRest").path("api").path("register").build());
		MultivaluedMap<String, String> formData = new MultivaluedMapImpl();
		formData.add("username", user.getUsername());
		formData.add("password", user.getPassword());
		ClientResponse response = webResource.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
				.post(ClientResponse.class, formData);
		System.out.println("Response " + response.getEntity(String.class));

	}

	public void PostRequestCountry(Country country) {
		WebResource webResource = client.resource(
				UriBuilder.fromUri("http://localhost:8181/TestMysqlRest").path("api").path("countries").build());
		MultivaluedMap<String, String> formData = new MultivaluedMapImpl();
		formData.add("country_name", country.getCountry_name());
		ClientResponse response = webResource.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
				.post(ClientResponse.class, formData);
		System.out.println("Response " + response.getEntity(String.class));
	}

	public void PostRequestDepartment(Department department) {
		WebResource webResource = client.resource(
				UriBuilder.fromUri("http://localhost:8181/TestMysqlRest").path("api").path("departments").build());
		MultivaluedMap<String, String> formData = new MultivaluedMapImpl();
		formData.add("country_id", String.valueOf(department.getCountry_id()));
		formData.add("department_name", department.getDepartment_name());
		ClientResponse response = webResource.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
				.post(ClientResponse.class, formData);
		System.out.println("Response " + response.getEntity(String.class));
	}

	public void PostRequestCity(City city) {
		WebResource webResource = client.resource(
				UriBuilder.fromUri("http://localhost:8181/TestMysqlRest").path("api").path("cities").build());
		MultivaluedMap<String, String> formData = new MultivaluedMapImpl();
		formData.add("department_id", String.valueOf(city.getDepartment_id()));
		formData.add("city_name", city.getCity_name());
		ClientResponse response = webResource.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
				.post(ClientResponse.class, formData);
		System.out.println("Response " + response.getEntity(String.class));
	}

}

package Requests;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.UriBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import Entities.Entity;

public class GetRequests {

	Client client = Client.create();

	public List<Entity> getAllData() {
		WebResource webResource = client.resource(
				UriBuilder.fromUri("http://localhost:8181/TestMysqlRest").path("api").path("alldata").build());
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		List<Entity> entities = new ArrayList<Entity>();
		
		if (response.getStatus() != 200)
			throw new RuntimeException("Failed : HTTP error code: " + response.getStatus());
		
		JSONArray json = new JSONArray(response.getEntity(String.class).toString());
		
		for (int i = 0; i < json.length(); i++) {
			JSONObject data = json.getJSONObject(i);
			Entity entity = new Entity();
			entity.getCountry().setCountry_id(data.getJSONObject("country").getInt("country_id"));
			entity.getCountry().setCountry_name(data.getJSONObject("country").getString("country_name"));
			entity.getDepartment().setCountry_id(data.getJSONObject("department").isNull("country_id")? null : data.getJSONObject("department").getInt("country_id"));
			entity.getDepartment().setDepartment_id(data.getJSONObject("department").getInt("department_id"));
			entity.getDepartment().setDepartment_name(data.getJSONObject("department").isNull("department_name")?null:data.getJSONObject("department").getString("department_name"));
			entity.getCity().setCity_id(data.getJSONObject("city").getInt("city_id"));
			entity.getCity().setCity_name(data.getJSONObject("city").isNull("city_name")? null : data.getJSONObject("city").getString("city_name"));
			entity.getCity().setDepartment_id(data.getJSONObject("city").getInt("department_id"));
			entities.add(entity);
		}

		return entities;
	}

}

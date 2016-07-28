package Beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import Entities.Entity;

@ManagedBean
@RequestScoped
public class DataBean {
	
	CommonBean bean = new CommonBean();
	
	List<Entity> entities = new ArrayList<Entity>();
	
	public List<Entity> getEntities() {
		return entities;
	}
	
	public void setEntities(List<Entity> entities) {
		this.entities = entities;
	}
	
	public void listEntities() {
		entities = bean.allData();
	}

}

package Beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entities.User;
import Requests.PostRequests;

@ManagedBean
@SessionScoped
public class UserBean {
	
	PostRequests postRequests = new PostRequests();
	
	public void addUser(User user) {
		if (user.getUsername() == null || user.getPassword() == null)
			System.out.println("username and password are required");
		else
			postRequests.PostRequestUser(user);
	}

}

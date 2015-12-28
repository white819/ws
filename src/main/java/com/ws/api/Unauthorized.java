package com.ws.api;

import com.ws.bean.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/unauth")
public class Unauthorized {
	@Autowired
	private UserService userService;
	
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User login(User user) {
		User ur = userService.logIn(user);
		return ur;
		
	}
	
	@POST
	@Path("/logins")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response logins(User user) {
		User ur = userService.logIn(user);
		String token = issueToken(ur.getName(), ur.getPassword());
		return Response.ok(token).build();
		
	}
	
	@GET
	@Path("/getUsers")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUsers() {
		/*UserRecord userRecord = new UserRecord();
		userRecord.setName("macx");
		
		return userRecord;*/
		
		User userRecord = new User();
		userRecord.setName("macx");
		
		return userRecord;
		/*Welcome welcome = new Welcome();
		welcome.setDomain("www.javahash.com");
		welcome.setMessage("JSON Example");
		return welcome;*/
		
	}
	
	private String issueToken(String userName, String password) {

		return userName+"123"+password;
	}
}
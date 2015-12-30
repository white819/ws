package com.ws.api;

import com.jpa.model.UserEntity;
import com.service.UserService;
import com.ws.bean.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by machaox on 12/29/2015.
 */
@Path("/auth/user")
public class UserApi {
    @Autowired
    private UserService userService;

    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User createUser(User user) {
        User ur = userService.addUser(user);
        return ur;

    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("id") int id) {
        User ur = userService.findById(id);

        return ur;

    }

    @PUT
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User updUser(User user) {
        User ur = userService.updUser(user);
        return ur;

    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delUser(@PathParam("id") int id) {
        userService.delById(id);
        return Response.ok().build();

    }

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserEntity> getUsers() {
       return userService.findAll();

    }
}

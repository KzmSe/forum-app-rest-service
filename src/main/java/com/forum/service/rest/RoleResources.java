package com.forum.service.rest;

import com.forum.service.dao.UserDaoImpl;
import com.forum.service.model.Action;
import com.forum.service.model.ResponseModel;
import com.forum.service.service.UserService;
import com.forum.service.service.UserServiceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("roles")
public class RoleResources {

    private UserService userService = new UserServiceImpl(new UserDaoImpl());

    @GET
    @Path("/{id}/actions")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel getActionsByRoleId(@PathParam("id") int id) throws SQLException {
        List<Action> list = userService.getActionListByRoleId(id);
        ResponseModel responseModel = new ResponseModel();
        responseModel.withStatusSuccess();
        responseModel.setBody(list);
        return responseModel;
    }

}

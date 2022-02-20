package com.jersey.example.controller;

import com.jersey.example.dao.EmployeeDAO;
import com.jersey.example.entity.Employee;
import com.jersey.example.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeDAO dao;

    @POST
    @Path("/save")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveUser(Employee employee) throws ServiceException {
        if (employee.getName() == null || employee.getName().isEmpty()) {
            throw new ServiceException("Name should not be null or empty", HttpStatus.BAD_REQUEST.value());
        }
        return Response.accepted().entity(dao.save(employee)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllEmployees() {
        return Response.ok().entity(dao.findAll()).build();
    }
}

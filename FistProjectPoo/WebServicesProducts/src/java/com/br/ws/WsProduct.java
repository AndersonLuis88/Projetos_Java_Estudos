/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.ws;

import com.br.dao.UserDAO;
import com.br.model.Users;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author Home
 */
@Path("products")
public class WsProduct {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of WsProduct
     */
    public WsProduct() {
    }

    /**
     * Retrieves representation of an instance of com.br.ws.WsProduct
     * @return an instance of java.lang.String "application/json"
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        return "Web Service Test";
    }
    
    //usuário
    @GET
    @Produces("application/json")
    @Path("user/list")
    public String listUsers() {
        //TODO return proper representation object
        List<Users> listUsers;
        
        UserDAO  uDAO = new UserDAO();
        
        listUsers = uDAO.list();
        
        //Converter classe Users para json
        
        Gson obj = new Gson();
        
        return obj.toJson(listUsers);
        
    }

    /**
     * PUT method for updating or creating an instance of WsProduct
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}

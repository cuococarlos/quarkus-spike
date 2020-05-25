package org.acme.security.jwt;

import java.security.Principal;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.acme.model.User;
import org.acme.service.*;
import org.eclipse.microprofile.jwt.JsonWebToken;


@Path("/secured/")
@RequestScoped
public class TokenSecuredResource {


    @Inject
    JsonWebToken jwt; 

    @Inject
    private UserService userService;
 
    @GET()
    @Path("roles-allowed") 
    @RolesAllowed({"Echoer", "Subscriber"}) 
    @Produces(MediaType.TEXT_PLAIN)
    public String helloRolesAllowed(@Context SecurityContext ctx) {
        Principal caller =  ctx.getUserPrincipal();
        String name = caller == null ? "anonymous" : caller.getName();
        boolean hasJWT = jwt.getClaimNames() != null;
        String helloReply = String.format("hello + %s, isSecure: %s, authScheme: %s, hasJWT: %s", name, ctx.isSecure(), ctx.getAuthenticationScheme(), hasJWT);
        return helloReply;
    }

    @POST
    @Path("/add/user")
    @Produces("application/json")
    public Response addUser(User user){
        userService.addUser(user);
        return Response.ok().build();
    }

    @GET
    @Path("/users")
    @Produces("application/json")
    @PermitAll 
    public Response getUsers(@Context SecurityContext ctx){
        Principal caller =  ctx.getUserPrincipal(); 
        String name = caller == null ? "anonymous" : caller.getName();
        boolean hasJWT = jwt.getClaimNames() != null;
        List<User> users = userService.getUsers();
        return Response.ok(users).build();
    }



}   
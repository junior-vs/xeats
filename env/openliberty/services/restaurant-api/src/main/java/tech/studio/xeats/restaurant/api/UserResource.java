package tech.studio.xeats.restaurant.api;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import tech.studio.xeats.restaurant.shared.security.dtos.UserDto;
import tech.studio.xeats.restaurant.shared.security.model.User;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

  @PersistenceContext
  EntityManager manager;

  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional
  public Response getUserById(@PathParam("id") Long id){
    User user = manager.find(User.class, id);


    return Response.ok(new UserDto(user)).build();
  }




}

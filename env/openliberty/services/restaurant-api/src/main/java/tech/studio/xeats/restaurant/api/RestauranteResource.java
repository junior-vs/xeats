package tech.studio.xeats.restaurant.api;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;
import tech.studio.xeats.restaurant.model.Restaurante;
import tech.studio.xeats.restaurant.model.RestauranteDto;

@Path("/restaurante")
@Produces(MediaType.APPLICATION_JSON)
public class RestauranteResource {

  @PersistenceContext
  EntityManager manager;
  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response findById(@PathParam("id") Long id) {

    Restaurante restaurante = manager.find(Restaurante.class, id);

    return Response.ok(new RestauranteDto(restaurante)).build();

  }

  /**
   * TODO - lista com paginação
   * */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getList() {

    List<Restaurante> resultList = manager.createNamedQuery("Restaurante.findAll").getResultList();

    List<RestauranteDto> collect = resultList.stream().map(RestauranteDto::new)
        .collect(Collectors.toList());
    return Response.ok(collect).build();

  }

  @GET
  @Path("/count")
  @Produces(MediaType.APPLICATION_JSON)
  public Response count() {
    Long count = (Long) manager.createNamedQuery("Restaurante.countBy").getSingleResult();
    return Response.ok(count).build();
  }

  @GET
  @Path("/nome/{name}")
  public Response findByName(@PathParam("name") String name) {
    Query namedQuery = manager.createNamedQuery("Restaurante.findByNome", Restaurante.class);
    namedQuery.setParameter("nome", name);
    List<Restaurante> resultList = namedQuery.getResultList();
    List<RestauranteDto> collect = resultList.stream().map(RestauranteDto::new)
        .collect(Collectors.toList());
    return Response.ok(collect).build();
  }


}

package br.com.digital.barber.shop.ports.clients;


import br.com.digital.barber.shop.ports.clients.dtos.TesteDTO;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/extensions")
@RegisterRestClient
public interface ClientDataTest {

    @GET
    Uni<TesteDTO> testeClient(@PathParam("data") String data);
}

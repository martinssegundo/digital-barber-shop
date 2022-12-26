package br.com.digital.barber.shop.ports.rest;


import br.com.digital.barber.shop.domain.usercases.ClientUsercase;
import br.com.digital.barber.shop.ports.dto.ClientDTO;
import io.micrometer.core.annotation.Counted;
import io.smallrye.mutiny.Uni;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("client/v1")
@ApplicationScoped
@Slf4j
public class ClientRegisterAPI {

    private ClientUsercase clientUsercase;

    @Inject
    public ClientRegisterAPI(ClientUsercase clientUsercase){
        this.clientUsercase = clientUsercase;
    }

    @POST
    @Path("new")
    @Counted("save")
    public Uni<Response> save(ClientDTO client){
        return clientUsercase.testeClient(client.getName())
                .map(item -> Response.status(201).build())
                .onFailure()
                .recoverWithItem(Response.status(HttpStatus.SC_NO_CONTENT).build());
    }

    @GET
    @Path("/client/{id}")
    @Counted("get")
    public Response getClient(@PathParam("id") Long id){
        return Response.ok(clientUsercase.testeClient("1")).build();
    }
}

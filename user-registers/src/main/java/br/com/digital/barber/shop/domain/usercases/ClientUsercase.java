package br.com.digital.barber.shop.domain.usercases;

import br.com.digital.barber.shop.ports.clients.ClientDataTest;
import br.com.digital.barber.shop.ports.dto.ClientDTO;
import io.smallrye.mutiny.Uni;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@Slf4j
public class ClientUsercase {
    private ClientDataTest clientDataTest;

    @Inject
    public ClientUsercase(@RestClient ClientDataTest clientDataTest){
        this.clientDataTest = clientDataTest;
    }



    public Uni<ClientDTO> testeClient(String test){
        return clientDataTest.testeClient(test)
                .map(client -> createClient(client))
                .onFailure()
                .invoke(error -> log.error(error.getMessage()));
    }


    private ClientDTO createClient(String test){
        log.info("Criando um cliente para add");
        var client = new ClientDTO();
        client.setName(test);
        return client;
    }
}

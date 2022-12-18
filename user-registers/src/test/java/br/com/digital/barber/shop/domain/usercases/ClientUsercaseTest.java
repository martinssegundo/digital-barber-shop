package br.com.digital.barber.shop.domain.usercases;

import br.com.digital.barber.shop.domain.usercases.mocks.WiremockClientData;
import br.com.digital.barber.shop.ports.dto.ClientDTO;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.mutiny.helpers.test.UniAssertSubscriber;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;



@QuarkusTest
@QuarkusTestResource(WiremockClientData.class)
public class ClientUsercaseTest {

    @Inject
    private ClientUsercase clientUsercase;

    @Test
    void testTesteClient() {
        clientUsercase.testeClient("1")
                .subscribe()
                .withSubscriber(UniAssertSubscriber.create())
                .assertCompleted()
                .assertItem(createClient("Luiz"));
    }


    private ClientDTO createClient(String test){
        var client = new ClientDTO();
        client.setName(test);
        return client;
    }
}
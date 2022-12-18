package br.com.digital.barber.shop.domain.usercases.mocks;

import br.com.digital.barber.shop.domain.usercases.ClientUsercaseTest;
import com.github.tomakehurst.wiremock.WireMockServer;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class WiremockClientData implements QuarkusTestResourceLifecycleManager {

    private WireMockServer wireMOckServer;

    @Override
    public Map<String, String> start() {
        wireMOckServer = new WireMockServer();
        wireMOckServer.start();
        String json;
        var loader = ClientUsercaseTest.class.getClassLoader().getSystemClassLoader();
        try {
            json = new String(
                    loader.getResourceAsStream("jsons/testeoud.json").readAllBytes()
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stubFor(
                get(urlEqualTo("/extensions"))
                .willReturn(
                        aResponse()
                                .withHeader("Content-Type", "application/json")
                                .withBody(json)
                )
        );
        stubFor(
                get(urlMatching(".*"))
                        .atPriority(10)
                        .willReturn(
                                aResponse().proxiedFrom("http://teste.com")
                        )
        );
        return Collections.singletonMap("br.com.digital.barber.shop.ports.clients.ClientDataTest/mp-rest/url", wireMOckServer.baseUrl());
    }

    @Override
    public void stop() {
        if(wireMOckServer != null)
            wireMOckServer.stop();
    }
}

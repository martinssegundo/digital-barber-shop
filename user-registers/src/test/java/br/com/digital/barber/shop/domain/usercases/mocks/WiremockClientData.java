package br.com.digital.barber.shop.domain.usercases.mocks;

import br.com.digital.barber.shop.domain.usercases.ClientUsercaseTest;
import br.com.digital.barber.shop.util.JsonReader;
import com.github.tomakehurst.wiremock.WireMockServer;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.apache.http.HttpStatus;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class WiremockClientData implements QuarkusTestResourceLifecycleManager {

    private WireMockServer wireMOckServer;

    @Override
    public Map<String, String> start() {
        wireMOckServer = new WireMockServer();
        wireMOckServer.start();
        configSucess();
        configError();

        return Collections.singletonMap("br.com.digital.barber.shop.ports.clients.ClientDataTest/mp-rest/url", wireMOckServer.baseUrl());
    }

    private void configSucess(){
        String json= JsonReader.getJson();
        stubFor(
                get(urlPathMatching("/teste/Luiz"))
                        .willReturn(
                                okJson(json)
                        )
        );
    }


    private void configError(){
        String json = JsonReader.getJsonError();
        stubFor(
                get(urlEqualTo("/teste/Luiz2"))
                        .willReturn(
                                aResponse()
                                        .withHeader("Content-Type", "application/json")
                                        .withStatus(HttpStatus.SC_CONFLICT)
                                        .withBody(json)
                        )
        );
    }

    @Override
    public void stop() {
        if(wireMOckServer != null)
            wireMOckServer.stop();
    }
}

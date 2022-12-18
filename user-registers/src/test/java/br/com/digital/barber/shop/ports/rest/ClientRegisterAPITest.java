package br.com.digital.barber.shop.ports.rest;

import br.com.digital.barber.shop.domain.usercases.ClientUsercaseTest;
import br.com.digital.barber.shop.domain.usercases.mocks.WiremockClientData;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.eclipse.jetty.http.HttpStatus;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

@QuarkusTest
@QuarkusTestResource(WiremockClientData.class)
class ClientRegisterAPITest {

    @Test
    void testSave() {

        given()
                .contentType(ContentType.JSON)
                .body(getJson())
                .when().post("client/v1/new")
                .then()
                .statusCode(HttpStatus.CREATED_201);
    }

    //@Test
    void testGetClient() {

    }



    private String getJson(){
        String json;
        var loader = ClientUsercaseTest.class.getClassLoader().getSystemClassLoader();
        try {
            json = new String(
                    loader.getResourceAsStream("jsons/testeoud.json").readAllBytes()
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return json;
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
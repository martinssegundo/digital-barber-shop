package br.com.digital.barber.shop.ports.rest;

import br.com.digital.barber.shop.domain.usercases.ClientUsercaseTest;
import br.com.digital.barber.shop.domain.usercases.mocks.WiremockClientData;
import br.com.digital.barber.shop.util.JsonReader;
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
                .body(JsonReader.getJson())
                .when().post("client/v1/new")
                .then()
                .statusCode(HttpStatus.CREATED_201);
    }

    @Test
    void testSaveError() {

        given()
                .contentType(ContentType.JSON)
                .body(JsonReader.getJsonError())
                .when().post("client/v1/new")
                .then()
                .statusCode(org.apache.http.HttpStatus.SC_NO_CONTENT);
    }

    //@Test
    void testGetClient() {

    }




}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
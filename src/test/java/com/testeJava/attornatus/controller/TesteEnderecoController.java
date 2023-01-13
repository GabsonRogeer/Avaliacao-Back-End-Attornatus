package com.testeJava.attornatus.controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeClass;

/**
 * @author Gabson Portela
 *
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TesteEnderecoController {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Test
    public void deveListarEnderecos(){

        RestAssured.given()
                .when()
                .get("/endereco")
                .then()
                .statusCode(200);
    }

    @Test
    public void deveExcluirEndereco() {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/endereco/1")
                .then()
                .statusCode(204);
    }
}

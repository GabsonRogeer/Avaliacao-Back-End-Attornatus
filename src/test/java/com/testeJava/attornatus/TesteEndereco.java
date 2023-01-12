package com.testeJava.attornatus;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeClass;

/**
 * @author Gabson Portela
 *
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TesteEndereco {

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
}

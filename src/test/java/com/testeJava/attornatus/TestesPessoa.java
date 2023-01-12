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
public class TestesPessoa {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Test
    public void deveListarPessoas(){

        RestAssured.given()
                .when()
                .get("/pessoa")
                .then()
                .statusCode(200);
    }

    @Test
    public void deveCadastrarPessoa() {
        RestAssured.given()
                .body("{\"nome\": \"Joao\",\"dataNascimento\": \"1995-10-10\"}")

                .contentType(ContentType.JSON)
                .when()
                .post("/pessoa")
                .then()
                .statusCode(201)

                .body("nome", Matchers.is("Joao"))
                .body("dataNascimento", Matchers.is("1995-10-10"));
    }

    @Test
    public void deveAtualizarPessoa() {
        RestAssured.given()
                .body("{\"nome\": \"André\",\"dataNascimento\": \"1994-09-09\"}")
                .contentType(ContentType.JSON)
                .when()
                .put("pessoa/3")
                .then()
                .statusCode(200)

                .body("nome", Matchers.is("André"))
                .body("dataNascimento", Matchers.is("1994-09-09"));
    }

    @Test
    public void deveDeletarPessoa() {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/pessoa/4")
                .then()
                .statusCode(204);
    }
}

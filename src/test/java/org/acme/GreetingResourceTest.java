package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
            .when().get("/hello?f=andy&b=2")
            .then()
            .statusCode(200)
            .body(is("Hello from RESTEasy Reactive andy 2"));
    }

    @Test
    public void testHelloBugEndpoint() {
        final Data d = new Data();
        d.foo = "john";
        d.bar = 5;
        given()
            .contentType(ContentType.JSON)
            .body(d)
            .when().post("/hello")
            .then()
            .log().ifError()
            .statusCode(200)
            .body(is("Hello from RESTEasy Reactive john 5"));
    }

    @Test
    public void testHelloRawEndpoint() {
        final Data d = new Data();
        d.foo = "john";
        d.bar = 5;
        given()
            .contentType(ContentType.JSON)
            .body(d)
            .when().post("/hello/raw")
            .then()
            .log().ifError()
            .statusCode(200)
            .body(is("Hello from RESTEasy Reactive john 5"));
    }

}
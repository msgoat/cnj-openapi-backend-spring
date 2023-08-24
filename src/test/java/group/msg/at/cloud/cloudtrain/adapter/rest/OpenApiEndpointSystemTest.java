package group.msg.at.cloud.cloudtrain.adapter.rest;

import group.msg.at.cloud.common.test.rest.RestAssuredSystemTestFixture;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

/**
 * System test that verifies that the OpenAPI REST endpoint works as expected.
 * <p>
 * Assumes that a remote server hosting the REST endpoint is up and running.
 * </p>
 */
public class OpenApiEndpointSystemTest {

    private static final RestAssuredSystemTestFixture fixture = new RestAssuredSystemTestFixture();

    @BeforeAll
    public static void onBeforeClass() {
        fixture.onBefore();
    }

    @AfterAll
    public static void onAfterClass() {
        fixture.onAfter();
    }

    @Test
    void getOpenApiWithDefaultUriReturns200AndOpenApiJson() {
        given().get("/v3/api-docs")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    @Test
    void getOpenApiWithYamlUriReturns200AndOpenApiYaml() {
        given().get("/v3/api-docs.yaml")
                .then()
                .statusCode(200)
                .contentType("application/vnd.oai.openapi");
    }

    @Test
    void getSwaggerUiReturns200AndHtml() {
        given().get("/swagger-ui/index.html")
                .then()
                .statusCode(200)
                .contentType(ContentType.HTML);
    }
}

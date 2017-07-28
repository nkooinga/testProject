package authentication;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PoctAuth {

    RequestSpecification rspec;
    RequestSpecBuilder build;

    private static String KEYCLOAK_URL = "https://keycloak.poct.stchome.net/auth/realms/Walmart/protocol/openid-connect/token";
    private static String KEYCLOAK_REALM = "Walmart";
    private static String KEYCLOAK_SN_IWEB_USER = "lu";
    private static String KEYCLOAK_SN_IWEB_PASSWORD = "lu";
    private static String KEYCLOAK_CLIENT = "account";
    private static String KEYCLOAK_SECRET = "ca2701df-8433-4316-ba9d-1bfbc576869c";
    private static String KEYCLOAK_GRANT_TYPE = "password";

    public String accessIWebToken;



    @BeforeClass
    public void requestSpec() {
        build  = new RequestSpecBuilder();
        build.setBaseUri("http://immslink.poct.stchome.net");
        build.setBasePath("/");

        rspec = build.build();

    }

    @Test
    public void getToken() {
        accessIWebToken = given()
                .formParam("grant_type", KEYCLOAK_GRANT_TYPE, "clientId", KEYCLOAK_CLIENT)
                .params("username", KEYCLOAK_SN_IWEB_USER, "password", KEYCLOAK_SN_IWEB_PASSWORD)
                .auth()
                .preemptive()
                .basic(KEYCLOAK_CLIENT, KEYCLOAK_SECRET)
                .when()
                .post(KEYCLOAK_URL)
                .then()
                .log()
                .all()
                .extract()
                .path("access_token");
        System.out.println(accessIWebToken);

    }


//    @Test
//    public void getPoctAuth() {
//        RestAssured.defaultParser = Parser.JSON;
//        getToken();
//
//        given()
//                .auth().preemptive().oauth2(accessIWebToken)
//                .contentType("application/json")
//                .spec(rspec)
//                .get("http://immslink.poct.stchome.net")
//                .then()
//                .log()
//                .all();
//    }
}

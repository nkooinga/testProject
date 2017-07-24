package authentication;

import static io.restassured.RestAssured.given;

public class IWebAuth {

    private static String KEYCLOAK_URL = "https://kcuat.stchome.com/auth/realms/sn/protocol/openid-connect/token";
    private static String KEYCLOAK_REALM = "sn";
    private static String KEYCLOAK_SN_IWEB_USER = "nick_sn";
    private static String KEYCLOAK_SN_IWEB_PASSWORD = "nick_sn";
    private static String KEYCLOAK_CLIENT = "sn-api-blade";
    private static String KEYCLOAK_SECRET = "d32ebcc5-0d52-4fd4-806e-a2911c19b0fd";
    private static String KEYCLOAK_GRANT_TYPE = "password";

    public String accessIWebToken;

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
}

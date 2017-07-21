package authentication;

import static io.restassured.RestAssured.given;

public class KeycloakRestApiManager {

//    Localhost keycloak
//    private static String KEYCLOAK_URL = "http://localhost:8081/auth";
//    private static String KEYCLOAK_REALM = "Test-Realm";
//    private static String KEYCLOAK_SN_IWEB_USER = "test";
//    private static String KEYCLOAK_SN_IWEB_PASSWORD = "test";
//    private static String KEYCLOAK_CLIENT = "iweb";
//    private static String KEYCLOAK_SECRET = "7ea395c9-5a7b-43ff-a8e4-e39a8c14448c";
//    private static String KEYCLOAK_GRANT_TYPE = "password";

//    Blade Keycloak
//    private static String KEYCLOAK_URL = "https://kcuat.stchome.com/auth";
//    private static String KEYCLOAK_REALM = "sn";
//    private static String KEYCLOAK_SN_IWEB_USER = "test";
//    private static String KEYCLOAK_SN_IWEB_PASSWORD = "test";
//    private static String KEYCLOAK_CLIENT = "sn-api-blade";
//    private static String KEYCLOAK_SECRET = "d32ebcc5-0d52-4fd4-806e-a2911c19b0fd";
//    private static String KEYCLOAK_GRANT_TYPE = "password";

//  Heroku keycloak
    private static String KEYCLOAK_URL = "https://kcuat.stchome.com/auth/realms/sn/protocol/openid-connect/token";
    private static String KEYCLOAK_REALM = "sn";
    private static String KEYCLOAK_SN_IWEB_USER = "nick_sn";
    private static String KEYCLOAK_SN_IWEB_PASSWORD = "nick_sn";
    private static String KEYCLOAK_CLIENT = "schoolnurse";
    private static String KEYCLOAK_SECRET = "d32ebcc5-0d52-4fd4-806e-a2911c19b0fd";
    private static String KEYCLOAK_GRANT_TYPE = "password";

//    public Keycloak getKeycloakInstance()
//    {
//        return KeycloakBuilder
//                .builder()
//                .serverUrl(KEYCLOAK_URL)
//                .serverUrl(KEYCLOAK_URL)
//                .realm(KEYCLOAK_REALM)
//                .username(KEYCLOAK_SN_IWEB_USER)
//                .password(KEYCLOAK_SN_IWEB_PASSWORD)
//                .clientId(KEYCLOAK_CLIENT)
//                .clientSecret(KEYCLOAK_SECRET)
//                .grantType(KEYCLOAK_GRANT_TYPE)
//                .build();
//
//    }
//
//
//    public AccessTokenResponse getAccessTokenResponse()
//    {
//        AccessTokenResponse tokenResp =  getKeycloakInstance().tokenManager().getAccessToken();
//        return tokenResp;
//
//    }
//


    public String accessToken;

    public void getToken() {
        accessToken = given()
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
        System.out.println(accessToken);

    }
}

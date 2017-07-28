package rosterapi;

import authentication.KeycloakRestApiManager;
import com.stc.roster.api.Payload;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.AuthenticationSpecification;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Created by nkooinga on 6/5/2017.
 */
public class RosterPaginationTest {

    //    InputStream apiProps = getClass().getResourceAsStream("com.stc.roster/properties/apienv.properties");
//    Properties prop = new Properties();
//    prop.load(apiProps);
    RequestSpecification rspec;
    RequestSpecBuilder build;
    AuthenticationSpecification login;
    KeycloakRestApiManager kram;


    @BeforeClass
    public void requestSpec() {
        build  = new RequestSpecBuilder();
        build.setBaseUri("https://sn-api.herokuapp.com");
        build.setBasePath("/roster");

        rspec = build.build();

    }

    @Test
    public void authTest() {
        kram = new KeycloakRestApiManager();
        kram.getToken();


    }




    //Tests for IWEBMODERN-80
    @Test (dataProvider = "rosterPaginationValues", dataProviderClass = Payload.class)
    public void happyRosterPageValues(String pageNum, String pageValues) {

        given()
                .auth().preemptive().oauth2(kram.accessToken)
                .spec(rspec)
                .queryParam("page", pageNum)
                .queryParam("valuesPerPage", pageValues)
                .when()
                .get("")
                .then()
                .assertThat()
                .body("currentPage", equalTo(Integer.parseInt(pageNum))).and().body("valuesPerPage",equalTo(Integer.parseInt(pageValues)))
                .and().statusCode(200)
                .and()
                .log()
                .all();

    }

    @Test (dataProvider = "rosterPaginationValues", dataProviderClass = Payload.class)
    public void negRosterPageValues(String pageNum, String pageValues) {

        given()
                .auth().preemptive().oauth2(kram.accessToken)
                .spec(rspec)
                .queryParam("page", pageNum)

                .queryParam("valuesPerPage", pageValues)
                .when()
                .get("")
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test (dataProvider = "rosterPaginationValues", dataProviderClass = Payload.class)
    public void invRosterPageValues(String pageNum, String pageValues) {

        given()
                .auth().preemptive().oauth2(kram.accessToken)
                .spec(rspec)
                .queryParam("page", pageNum)
                .queryParam("valuesPerPage", pageValues)
                .when()
                .get("")
                .then()
                .assertThat()
                .statusCode(400);
    }

    @Test
    public void sortOrderAscFirstName() {

        given()
                .auth().preemptive().oauth2(kram.accessToken)
                .spec(rspec)
                .queryParam("page", "1")
                .queryParam("sortBy", "firstName")
                .queryParam("sortOrder", "asc")
                .when()
                .get("")
                .then()
                .assertThat()
                .body(".values.firstName[0]".substring(1), equalTo("Student1"));
    }

    @Test
    public void sortOrderDescFirstName() {

        given()
                .auth().preemptive().oauth2(kram.accessToken)
                .spec(rspec)
                .queryParam("page", "1")
                .queryParam("sortBy", "firstName")
                .queryParam("sortOrder", "desc")
                .when()
                .get("")
                .then()
                .assertThat()
                .body(".values.firstName[0]".substring(1), equalTo("Student1"));
    }

    @Test
    public void sortOrderAscLastName() {

        given()
                .auth().preemptive().oauth2(kram.accessToken)
                .spec(rspec)
                .queryParam("page", "1")
                .queryParam("sortBy", "lastName")
                .queryParam("sortOrder", "asc")
                .when()
                .get("")
                .then()
                .assertThat()
                .body(".values.lastName[0]".substring(1), equalTo("Test"));
    }

    @Test
    public void sortOrderDescLastName() {

        given()
                .auth().preemptive().oauth2(kram.accessToken)
                .spec(rspec)
                .queryParam("page", "1")
                .queryParam("sortBy", "lastName")
                .queryParam("sortOrder", "desc")
                .when()
                .get()
                .then()
                .assertThat()
                .body(".values.lastName[0]".substring(1), equalTo("Test"));
    }

//    @Test
//    public void getAllValues() {
//
//        Response res = given()
//                .spec(rspec)
//        .when()
//                .get("")
//        .then()
//                .extract()
//                .response();
//
//        JsonPath response = ReusableMethods.rawToJsonArray(res);
//
//        ArrayList<String> allValArray = new allValResponse.asString();
//        JsonPath js = ReusableMethods.rawToJsonRes(allValArray);
//        int count = js.get("values.size()");
//        for(int i=0;i<count;i++) {
//            System.out.println(js.get("values["+i+"].name"));
//        }
//
//        System.out.println(count);
//    }


}
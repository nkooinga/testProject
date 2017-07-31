package rosterapi;

import authentication.IWebAuth;
import com.aventstack.extentreports.Status;
import com.stc.roster.api.Payload;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.AuthenticationSpecification;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import reporting.ExtentUtil;

import static io.restassured.RestAssured.given;

/**
 * Created by nkooinga on 6/8/2017.
 */
public class rosterFormatTest {

    RequestSpecification rspec;
    RequestSpecBuilder build;
    AuthenticationSpecification login;
    IWebAuth iwa;
    ExtentUtil eu;


    @BeforeClass
    public void requestSpec() {
        build  = new RequestSpecBuilder();
        build.setBaseUri("http://bladeiwebwv.stchome.com:8080/SchoolNurse");
//        build.setBasePath("/schoolDistricts");

        rspec = build.build();

    }

    @Test
    public void accessIwebSchoolDistrict() {
        iwa = new IWebAuth();
        iwa.getToken();

        given()
                .auth().preemptive().oauth2(iwa.accessIWebToken)
                .spec(rspec)
                .queryParam("schoolID", "1")
                .when()
                .get("/schoolDistricts")
                .then()
                .log()
                .body();
    }

    @Test
    public void accessIwebSchools() {
        iwa = new IWebAuth();
        iwa.getToken();

        Response response = given()
                .auth().preemptive().oauth2(iwa.accessIWebToken)
                .spec(rspec)
                .queryParam("stateCode", "OH")
                .when()
                .get("/schools")
                .then()
                .log()
                .body()
                .and()
                .extract()
                .response();

        String json = response.asString();
        JsonPath jp = new JsonPath(json);
//        assertEquals();


    }

    @Test(dataProvider = "School ID", dataProviderClass = Payload.class)
    public void schoolIdSearch(String schoolId) {
        iwa = new IWebAuth();
        iwa.getToken();

        eu.fetchTest().log(Status.INFO, schoolId);

        given()
                .auth().preemptive().oauth2(iwa.accessIWebToken)
                .spec(rspec)
                .queryParam("stateCode", "OH")
                .queryParam("schoolId", schoolId)
                .when()
                .get("/schools")
                .then()
                .log()
                .all();
//                .and()
//                .assertThat()
//                .body("schoolId", equalTo(schoolId));
    }

//    @Test(dataProvider = "School ID", dataProviderClass = Payload.class)
//    public void validGrade(String schoolId, String gradeLevel) {
//        iwa = new IWebAuth();
//        iwa.getToken();
//
//        given()
//                .auth().preemptive().oauth2(iwa.accessIWebToken)
//                .spec(rspec)
//                .queryParam("schoolId", schoolId)
//                .queryParam("grade", gradeLevel)
//        .when()
//                .get("/getGradeLevels")
//        .then()
//                .log()
//                .body()
//                .and()
//                .assertThat()
//                .body("schoolId[*]", equalTo(schoolId))
//                .and()
//                .body("grade", equalTo(gradeLevel));
//
//
//    }

}

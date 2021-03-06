package rosterapi;

//import com.stc.roster.api.ReusableMethods;

import authentication.IWebAuth;
import authentication.KeycloakRestApiManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import reporting.ExtentUtil;

import static io.restassured.RestAssured.given;

public class ChangeGrade {

    RequestSpecification rspec;
    RequestSpecBuilder build;
    KeycloakRestApiManager kram;
    IWebAuth iwa;
    ExtentUtil eu;

    @BeforeClass
    public void requestSpec() {
        build  = new RequestSpecBuilder();
        build.setBaseUri("http://bladeiwebwv.stchome.com:8080/SchoolNurse");
        build.setBasePath("/grades");

        rspec = build.build();
    }

    @BeforeTest
    public void accessToken() {
        iwa = new IWebAuth();
        iwa.getToken();
    }

//    @Test
//    public void increaseGrade() {
//        Response response = given()
//                .auth().preemptive().oauth2(iwa.accessIWebToken)
//                .spec(rspec)
//                .queryParam("page", "1")
//                .queryParam("sortBy", "lastName")
//                .when()
//                .get("/list")
//                .then()
//                .extract()
//                //.response()
//                .path("list.student.findAll{grade<'12'}");

//        JsonPath js = ReusableMethods.rawToJsonArray(response);
//        System.out.println(js);

        //Add in grade incrementing logic below
        // for (int ng = )

//
//        given()
//                .spec(rspec)
//            .when()
//                .put("GRADE INCREMENTING")
//            .then()
//                .extract()
//                .body("list");

        //Add in body assertions to match new grade


//    }

    @Test
    public void getSchoolAllGrades() {
        Response response = given()
                .auth().preemptive().oauth2(iwa.accessIWebToken)
                .spec(rspec)
        .when()
                .get("")
        .then()
                .log()
                .body()
                .and()
                .extract()
                .response();

        String json = response.asString();
        JsonPath jp = new JsonPath(json);
//        eu.fetchTest().log(Status.INFO, json);
        System.out.println(jp);



    }




}

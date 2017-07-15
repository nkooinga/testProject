package rosterapi;

//import com.stc.roster.api.ReusableMethods;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ChangeGrade {

    RequestSpecification rspec;
    RequestSpecBuilder build;

    @BeforeClass
    public void requestSpec() {
        build  = new RequestSpecBuilder();
        build.setBaseUri("http://bladeiwebwv.stchome.com:8080/SchoolNurse");
        build.setBasePath("/roster");

        rspec = build.build();
    }

    @Test
    public void increaseGrade() {
        Response response = given()
                .spec(rspec)
                .queryParam("page", "1")
                .queryParam("sortBy", "lastName")
            .when()
                .get("/list")
            .then()
                .extract()
                //.response()
                .path("list.student.findAll{grade<'12'}");

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


    }




}

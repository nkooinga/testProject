package rosterapi;

import com.stc.roster.api.Payload;
import com.stc.roster.reporting.ExtentUtil;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Created by nkooinga on 6/5/2017.
 */
public class RosterPaginationTest extends Payload {

//    InputStream apiProps = getClass().getResourceAsStream("com.stc.roster/properties/apienv.properties");
//    Properties prop = new Properties();
//    prop.load(apiProps);
    RequestSpecification rspec;
    RequestSpecBuilder build;

    @BeforeClass
    public void requestSpec() {
        build  = new RequestSpecBuilder();
        build.setBaseUri("bladeiwebwv.stchome.com:8080/SchoolNurse");
        build.setBasePath("/Roster");

        rspec = build.build();
    }


    @BeforeSuite
    public void accessRosterPage() {

        ExtentUtil.fetchTest().assignCategory("Pagination Test");
        Assert.assertTrue(true);
        RestAssured.baseURI = "bladeiwebwv.stchome.com:8080/SchoolNurse";
        RestAssured.basePath = "/Roster";

        given()
                .spec(rspec)
        .when()
                .get("")
        .then()
                .assertThat()
                .statusCode(200)
                .log()
                .headers();

    }
//Tests for IWEBMODERN-80
    @Test (dataProvider = "rosterPaginationValues", dataProviderClass = Payload.class)
    public void happyRosterPageValues(String pageNum, String pageValues) {

        ExtentUtil.fetchTest().assignCategory("Pagination Test");
        Assert.assertTrue(true);

        given()
                .spec(rspec)
                .queryParam("page", pageNum)
                .queryParam("valuesPerPage", pageValues)
        .when()
                .get("")
        .then()
                .assertThat()
                .body("currentPage", equalTo(pageNum)).and().body("valuesPerPage",equalTo(pageValues))
                .and().statusCode(200)
                .and()
                .log()
                .body();
    }

    @Test (dataProvider = "rosterPaginationValues", dataProviderClass = Payload.class)
    public void negRosterPageValues(String pageNum, String pageValues) {

        ExtentUtil.fetchTest().assignCategory("Pagination Test");
        Assert.assertTrue(true);

        given()
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

        ExtentUtil.fetchTest().assignCategory("Pagination Test");
        Assert.assertTrue(true);

        given()
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

        ExtentUtil.fetchTest().assignCategory("Pagination Test");
        Assert.assertTrue(true);

        given()
                .spec(rspec)
                .queryParam("page", "1")
                .queryParam("sortBy", "firstName")
                .queryParam("sortOrder", "asc")
        .when()
                .get("")
        .then()
                .assertThat()
                .body("field.firstName[0]".substring(1), equalTo("A"));
    }

    @Test
    public void sortOrderDescFirstName() {

        ExtentUtil.fetchTest().assignCategory("Pagination Test");
        Assert.assertTrue(true);

        given()
                .spec(rspec)
                .queryParam("page", "1")
                .queryParam("sortBy", "firstName")
                .queryParam("sortOrder", "desc")
        .when()
                .get("")
        .then()
                .assertThat()
                .body("field.firstName[0]".substring(1), equalTo("Z"));
    }

    @Test
    public void sortOrderAscLastName() {

        ExtentUtil.fetchTest().assignCategory("Pagination Test");
        Assert.assertTrue(true);

        given()
                .spec(rspec)
                .queryParam("page", "1")
                .queryParam("sortBy", "lastName")
                .queryParam("sortOrder", "asc")
        .when()
                .get("")
        .then()
                .assertThat()
                .body("field.lastName[0]".substring(1), equalTo("A"));
    }

    @Test
    public void sortOrderDescLastName() {

        ExtentUtil.fetchTest().assignCategory("Pagination Test");
        Assert.assertTrue(true);

        given()
                .spec(rspec)
                .queryParam("page", "1")
                .queryParam("sortBy", "lastName")
                .queryParam("sortOrder", "desc")
        .when()
                .get()
        .then()
                .assertThat()
                .body("field.lastName[0]".substring(1), equalTo("Z"));
    }

//    @Test
//    public void getAllValues() {
//
//        ExtentUtil.fetchTest().assignCategory("Pagination Test");
//        Assert.assertTrue(true);
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
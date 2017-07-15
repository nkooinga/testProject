//package rosterapi;
//
//import io.restassured.http.ContentType;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.Test;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.Properties;
//
//import static io.restassured.RestAssured.given;
//import static io.restassured.RestAssured.patch;
//import static org.hamcrest.CoreMatchers.equalTo;
//import static org.hamcrest.Matchers.contains;
//import static org.hamcrest.Matchers.hasItems;
//
//public class NurseRosterSearch {
//
//    //Test for IWEBMODERN-116
//    @BeforeSuite
//    public void accessRosterPage() {
//        Properties prop = new Properties();
//        prop.get("HOST")
//        given()
//                .param(/*ROSTERURI*/)
//                .param(/*schoolNurseSelection*/)
//                .when()
//                .get("/com/stc/integrationtests/roster/api")
//                .then()
//                .assertThat()
//                .statusCode(200)
//                .log()
//                .headers();
//
//    }
//
//    @Test
//    public void accessRosterWithoutSchoolSelection() {
//        given()
//                .param(/*ROSTERURI*/)
//                .when()
//                .get()
//                .then()
//                .log()
//                .body();
//    }
//
//    @Test
//    public void accessRosterasSDCwithoutSchoolSeleciton() {
//        given()
//                .param(/*ROSTERURI*/)
//                .param(/*SDCPARAMS*/)
//                .when()
//                .get()
//                .then()
//                .log()
//                .body("/list");
//    }
//
//    @Test
//    public void accessRosterasSDCwithSchoolSelection() {
//        given()
//                .param(/*ROSTERURI*/)
//                .param(/*SDCPARAMS*/)
//                .when()
//                .get("/roster")
//                .then()
//                .log()
//                .body("rosterList.list");
//    }
//
//    //Tests for IWEBMODERN-116
//    @Test()
//    public void getSchoolRoster() {
//        given()
//                .param(/*schoolSpecificRoster*/)
//                .param(/*schoolNurse*/)
//                .when()
//                .get("/roster")
//                .then()
//                .assertThat()
//                .body("rosterList.count", equalTo(/*Number of kids in roster*/))
//                .body("rosterList.list", hasItems("schoolName","schoolAddress", "schoolPhone","schoolDistrict","firstName","lastName","grade","patientAddress","patientDOB","patientGuardian","patientForecast"))
//
//
//    }
//
//    @Test
//    public void searchSchoolRoster() {
//
//        Response studentSearchResponse = given()
//                .queryParam(/*studentParameters*/)
//                .when()
//                .get("/roster/search")
//                .then()
//                .assertThat()
//                .body("rosterList.list", hasItems("firstName", "lastName", "grade", "PatientAddress", " patientDOB", "patientGuardian", "patientForecast"))
//                .statusCode(200);
//    }
//
//    @Test
//    public void updateStudentInformation() {
//
//        Response studentSearchResponse = given()
//                .queryParam(/*studentParameters*/)
//                .when()
//                .get("/roster/search")
//                .then()
//                .assertThat()
//                .body("rosterList.list", hasItems("firstName", "lastName", "grade", "PatientAddress", " patientDOB", "patientGuardian", "patientForecast"))
//                .statusCode(200)
//                .extract()
//                .response();
//
//        ArrayList<String> studentSearchArray = new studentSearchResponse.asString();
//
//
//        String studentSearchString;
//        studentSearchString = studentSearchResponse.asString();
//        System.out.println(studentSearchString);
//        JsonPath js = new JsonPath(studentSearchString);
//        String studentInformation = js.get("STUDENT INFORMATION");
//        System.out.println(studentInformation);
//
//        given()
//                .queryParam("STUDENT to update")
//                .body(studentInformation)
//    }
//    //Tests for IWEBMODERN-117
//    @Test
//    public void linkStudentDemo() {
//        given()
//                .param(/*studentParameters*/)
//                .when()
//                .get("/studentDemographics")
//                .then()
//                .log()
//                .body()
//                .assertThat()
//                .statusCode(200);
//    }
//
//    @Test
//    public void linkStudentVacc() {
//        given()
//                .param(/*studentParameters*/)
//                .when()
//                .get("/studentVaccinations")
//                .then()
//                .log()
//                .body()
//                .statusCode(200);
//    }
//
//    @Test
//    public void linkStudentCIS() {
//        given()
//                .param(/*studentParameters*/)
//                .when()
//                .get("/studentForm")
//                .then()
//                .log()
//                .body()
//                .statusCode(200);
//    }
//
//    @Test
//    public void updateStudentGrade() {
//        given()
//                .contentType(ContentType.JSON)
//                .when()
//                .body(.param(/*studentParameters*/))
//                .patch()
//                .then()
//                .log()
//                .body(hasItem(/*NewGradeLevel*/));
//    }
//
//    //Tests for IWEBMDOERN-121
//    //Nurse should not be able to select school
//    @Test
//    public void nurseSchoolSearch() {
//        given()
//                .param(/*SchoolNurseCreds*/)
//                .param(/*SchoolSelection*/)
//                .when()
//                .get()
//                .then()
//                .assertThat()
//                .statusCode(504);
//    }
//    //School District Client Test
//    @Test
//    public void districtUserSchoolsView() {
//        given()
//                .param(/*districtUserParams*/)
//                .when()
//                .get("/list")
//                .then()
//                .log()
//                .body("schools.list", hasItems("schools"));
//    }
//
//    //Nurse switching grades of patients
//    @Test
//    public void nurseGradeChange() {
//
//
//        given()
//                .contentType(ContentType.JSON)
//                .param(/*Nurse Param*/)
//                .param(/*Grade Change Param*/)
//                .when()
//                .body(/*studentVarCall*/)
//                .post()
//                .then()
//                .assertThat()
//                .statusCode(201)
//                .body(contains(/*studentVarCall*/));
//
//
//    }
//
//    //Tests for IWEBMODERN-122
//    @BeforeMethod
//    public void rosterDownloadCheck() {
//        File rosterDownload = new File(System.getProperty("/*Download Directory Location*/") + File.separator + "/*File name*/");
//
//        int expectedSize = (int) rosterDownload.length();
//
//        System.out.println("Expected file size: " + expectedSize + " bytes");
//    }
//    @Test
//    public void rosterTemplateDownload() {
//
//        byte[] actualValue = given()
//                .when()
//                .get(/*DOWNLOADURL*/)
//                .then()
//                .extract()
//                .asByteArray();
//
//        assertThat(expectedSize, equalTo(actualValue.length));
//
//    }
//
//    @BeforeMethod
//    public void rosterUnmatchedDownloadCheck() {
//        File unmatchedCheck = new File(System.getProperty("/*Download Directory Location*/")  + File.separator + "/*File name*/");
//
//        int expectedSize = (int) unmatchedCheck.length();
//
//        System.out.println("Unmatched Download size is: " + expectedSize + " bytes");
//    }
//
//    @Test
//    public void unmatchedDownload() {
//        given()
//                .param(/*Unmatched Students Parameters*/)
//                .when()
//                .get("/unmatchedDownload")
//                .then()
//    }
//
//    //Tests for IWEBMODERN-16
//    @Test
//    public void rosterUpload() {
//        given()
//                .multiPart("Roster Upload File")
//                .when()
//                .post("/fileUploadPath")
//                .then()
//                .assertThat()
//                .body("fileUploadResult", equalTo("OK"))
//                .statuscode(302);
//
//    }
//
//    @Test
//    public void rosterUpload() {
//        given()
//                .multiPart("Roster Upload File")
//                .when()
//                .post("/fileUploadPath")
//                .then()
//                .assertThat()
//                .body("fileUploadResult", ("OK"))
//                .statuscode(302);
//}

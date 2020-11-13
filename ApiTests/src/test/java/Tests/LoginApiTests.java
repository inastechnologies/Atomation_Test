package Tests;


import ApiRequestAndResponse.UserRegistrationRequest;
import ApiRequestAndResponse.UserRegistrationResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static org.hamcrest.Matchers.equalTo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginApiTests extends BaseTestApi
{
    @Test
    public void VerifyUserRegisterSuccessfullyApiTest()
    {
        given()
                .when()
                    .get("http://13.235.235.58:8000/qnature/modalities")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void VerifyModalityListIsCorrect_ApiTest()
    {
       /*Response response =  given()
                .when()
                .get("http://ergast.com/api/f1/2017/circuits.json");
                //.then()
                //.log().all();
                //.statusCode(200);
        response.getBody().prettyPrint();*/

        given()
                .when()
                .get(BaseUrl + ModalitiesEndPoint)
                .then()
                .log().all()
                .statusCode(200)
                .assertThat()

                //.body("MRData.CircuitTable.Circuits.circuitId",hasSize(20));

                .body("message",equalTo("Modalities"))
                .body("result.output[0].title",equalTo("Any"))
                .body("result.output[1].title",equalTo("Vinyasa Yoga"))
                .body("result.output[2].title",equalTo("Viniyoga"))
                .body("result.output[3].title",equalTo("Sivananda Yoga"))
                .body("result.output[4].title",equalTo("Siddha Yoga"))
                .body("result.output[5].title",equalTo("Raja Yoga"));
    }

    @Test
    public void VerifyUserCanRegisterSuccessfully_ApiTest()
    {
        String payLoad = "{\"first_name\":\"rtey\",\"last_name\":\"abcd\",\"mobile_number\":\"9880000661\",\"email_id\":\"sss722788@gmail.com\",\"password\":\"In124@yyy\",\"confirm_password\":\"In124@yyy\",\"location\":\"hyd\",\"gender\":\"female\",\"type\":2,\"google_id\":\"\",\"facebook_id\":\"\"}";
        given()
                .when()
                .contentType(ContentType.JSON)
                .body(payLoad)
                .post(BaseUrl + SignUpEndPoint)
                .then()
                .log().all()
                .statusCode(200)
                .assertThat()
                .body("message", equalTo("User Sign Up successfully"))
                .body("result[0].email_id", equalTo("sss722788@gmail.com"))
                .body("result[0].first_name", equalTo("rtey"))
                .body("result[0].last_name", equalTo("abcd"))
                .body("result[0].location", equalTo("hyd"))
                .body("result[0].password", equalTo("In124@yyy"))
                .body("result[0].mobile_number", equalTo("9880000661"));
    }

    @Test
    public void VerifyUserCanRegisterSuccessfully1_ApiTest() throws JsonProcessingException
    {
        UserRegistrationRequest request = new UserRegistrationRequest();
        request.first_name = "jhk";
        request.last_name = "sgds";
        request.mobile_number = "9886685886";
        request.email_id = "jhkkkk35@gmail.com";
        request.confirm_password = "jkkkkHHH@123";
        request.facebook_id = "jhk@123";
        request.gender = "female";
        request.google_id = "";
        request.location = "Hyd";
        request.password = "jkkkkHHH@123";
        request.type = 2;

        ObjectMapper objectMapper = new ObjectMapper();
        var payLoad = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(request);

        Response response =
        given()
                .when()
                .contentType(ContentType.JSON)
                .body(payLoad)
                .post(BaseUrl + SignUpEndPoint);

        response.getBody().prettyPrint();

        //ResponseBody responseBody = response.getBody();
        UserRegistrationResponse registerResponse = response.getBody().as(UserRegistrationResponse.class);

        Assert.assertEquals(registerResponse.message, "User Sign Up successfully");
        Assert.assertEquals(registerResponse.result.get(0).mobile_number, "9886685886");
        Assert.assertEquals(registerResponse.result.get(0).email_id, "jhkkkk35@gmail.com");
        Assert.assertEquals(response.statusCode(), 200);
    }
}

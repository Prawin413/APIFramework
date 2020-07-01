package stepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefinition extends Utils {
	
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	static String place_Id;
	
	
	TestDataBuild data = new TestDataBuild();

	@Given("Add Place Payload with {string}  {string}  {string}")
	public void add_Place_Payload_with(String name, String language, String address) throws IOException {
    

 
 
res=given().spec(RequestSpecification())
.body(data.addPlacePayLoad(name, language, address));
//System.out.println(data.addPlacePayLoad(name, language, address));
}

	@When("User calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String httpMethod) {
  
	APIResources resourceAPI= APIResources.valueOf(resource);
	System.out.println(resourceAPI.getResources());
	
	resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	
	if(httpMethod.equalsIgnoreCase("POST"))	
	response =res.when().post(resourceAPI.getResources());
	else if(httpMethod.equalsIgnoreCase("GET"))
	response =res.when().post(resourceAPI.getResources());
	
//then().spec(resspec).extract().response();

}

@Then("API call got success with status code {int}")
public void api_call_got_success_with_status_code(Integer int1) {

	assertEquals(response.getStatusCode(),200);
}

@Then("{string} in response body is {string}")
public void in_response_body_is(String keyValue, String expectedValue) {
    
	 
	assertEquals(getJsonPath(response, keyValue),expectedValue);
	
}

@Then("Verify place_Id creatd maps to {string} using {string}")
public void verify_place_Id_creatd_maps_to_using(String expectedName, String resource) throws IOException {
    
	place_Id = getJsonPath(response, "place_id");
	res = given().spec(RequestSpecification()).queryParam("place_id", place_Id);
	user_calls_with_http_request(resource, "GET");
	String actualName = getJsonPath(response, "name");
	assertEquals(expectedName, actualName);
	
}



@Given("DeletePlace Payload")
public void deleteplace_Payload() throws IOException {
    
	res = given().spec(RequestSpecification()).body(data.deletePlacePayload(place_Id));
	
}


	
}

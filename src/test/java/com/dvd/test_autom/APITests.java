package com.dvd.test_autom;


import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.dvd.base.BaseAPITest;
import com.dvd.pages_Api.APIEndpoints;
import com.dvd.pages_Api.JsonPaths;
import com.dvd.utils.APIActions;
import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class APITests extends BaseAPITest {

	Faker faker = new Faker();
	String firstName = faker.name().firstName();
	String lastName = faker.name().lastName();
	String emailRan = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@gmail.com";
	
	int numberRandom = (int)(Math.random()*10) + 1;
	
	String regisPayload ="{\"user\":{\"first_name\":\""+firstName+"\",\"last_name\":\"\",\"email\":\""+emailRan+"\",\"password\":\"Testing1\",\"phone_number\":\"+62-81282829203\",\"user_type\":\"User\",\"currency_id\":"+numberRandom+"}}";
	String authtoken = "token not found";
	
	@Test(priority = 1)
	public void regisAPI() {
		
//		String regisPayload = DataUtils.getDataFromExcel("DataAss", "RegisLoad");
		
		Response regisResponse = RestAssured.given().spec(commonRequestSpec).body(regisPayload).when()
				.post(APIEndpoints.register);

		APIActions.verifyAPIResponseDetails(regisResponse);

		authtoken = APIActions.getResponseDataUsingJsonPath(regisResponse, JsonPaths.authToken);
		String email = APIActions.getResponseDataUsingJsonPath(regisResponse, JsonPaths.email);
		APIActions.getResponseDataUsingJsonPath(regisResponse, JsonPaths.currency);
		APIActions.getResponseDataUsingJsonPath(regisResponse, JsonPaths.currencyId);
		assertEquals(email, emailRan);
		



	}

//	@Test(priority = 2)
//	public void signOut() {
//
//		Response signOutResponse = RestAssured.given().spec(commonRequestSpec).formParam("authtoken", authtoken).when()
//				.delete(APIEndpoints.signOut);
//
////		Response dashboardResponse = RestAssured.given().spec(commonRequestSpec).formParam("status", "invited")
////				.header("authtoken", authtoken).when().get(APIEndpoints.dashboardAPI);
//		APIActions.verifyAPIResponseDetails(signOutResponse);
//
////		authtoken = APIActions.getResponseDataUsingJsonPath(regisResponse, JsonPaths.authToken);
//
////		assertEquals(loginResponse.getStatusCode(), 422);
//
//	}

}

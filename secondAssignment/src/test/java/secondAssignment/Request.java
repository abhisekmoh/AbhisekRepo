package secondAssignment;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Request {
	
	@Test (priority=2)
	void get() {
		
		given().when().get("https://reqres.in/api/users?page=2").then().statusCode(200).log()
		  .all();
	}
	
	@Test (priority=1)
	void post(){
		
		JSONObject postRequest = new JSONObject();
		
		postRequest.put("avatar", "https://s3.amazonaws.com//uifaces/faces//twitter//follettkyle//128.jpg");
		postRequest.put("last_name", "Mohanty");
		postRequest.put("first_name", "Abhisek");
		postRequest.put("email", "abhisek.zapp007@gmail.com");
		postRequest.put("id", "2");
		System.out.println("Post request: " + postRequest.toJSONString());
		given().body(postRequest.toJSONString()).
		when().post("https://reqres.in/api/users").
		then().statusCode(201);
	}
	
	@Test (priority=3)
	void put(){
		
		JSONObject putRequest = new JSONObject();
		putRequest.put("last_name", "Test123");
		putRequest.put("email", "abhisek.zapp007@gmail.co");
		System.out.println("Put request: " + putRequest.toJSONString());
		given().body(putRequest.toJSONString()).
		when().put("https://reqres.in/api/users/2").
		then().statusCode(200);
	}
	
	@Test (priority=4)
	void delete() {
		when().delete("https://reqres.in/api/users/2").
		then().statusCode(204).
		log().all();
	}

}

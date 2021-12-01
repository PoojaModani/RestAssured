package APITest;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class E_commerce {
	public static String baseurl = "https://ecommerceservice.herokuapp.com/";
    public Object accessToken;
	public Object id;

	@Test(priority = 0,enabled = false)
	public void signup()
	{
		RestAssured.baseURI = baseurl;
		
		String requestbody = "{\r\n"
				+ "	\"email\": \"pqr176@gmail.com\",\r\n"
				+ "	\"password\": \"pqr@123\"\r\n"
				+ "}\r\n"
				+ "";
		
		//this time i want to know what my response is in my console
		//there is interface Response fetches o/p frm get/ other method the body and stores in a variable called response
		Response response =given()
				.header("content-type","application/json")
				.body(requestbody)
				
		.when()
		.post("/user/signup")
		
		.then()
		.assertThat().statusCode(201).and().contentType(ContentType.JSON).
		extract().response();
		//is to print the response
		//basically the output format by default
		System.out.println(response.asString());
	}
	

	
	


@Test(priority = 1)
public void login()
{
	RestAssured.baseURI = baseurl;
	
	String requestbody ="{\r\n"
			+ "	\"email\": \"pqr176@gmail.com\",\r\n"
			+ "	\"password\": \"pqr@123\"\r\n"
			+ "}\r\n"
			+ "";
	// this time i want to know my what response is in my console
	Response response = given()
	  .header("content-Type","application/json")
	  .body(requestbody)
	
	  .when()
	  .post("/user/login")
	
	  .then()
	  .assertThat().statusCode(200).contentType(ContentType.JSON)
	  .extract().response();
	String jsonresponse = response.asString();
	JsonPath responsebody = new JsonPath(jsonresponse);
	System.out.println(responsebody.get("accessToken"));	
	accessToken = responsebody.get("accessToken");
}
	
@Test(priority = 2)
public void getusers()
{
	RestAssured.baseURI= baseurl;
	
	Response response = given()
			.header("content-Type","application/json")
			.header("Authorization","bearer "+accessToken)
			
			.when()
			.get("/user")
			
			.then()
			.assertThat().statusCode(200).and().contentType(ContentType.JSON)
			//To extract the response
			.extract().response();
			//output will be in string, have to convert to json
			String jsonresponse = response.asString();
			//convert from normal string to json
			JsonPath responsebody = new JsonPath(jsonresponse);
			System.out.println(responsebody.get("users[150]._id"));
			id=responsebody.get("users[150]._id");
}



@Test(priority = 3)
public void delete()
{
	RestAssured.baseURI= baseurl;
	
	Response response = given()
			.header("content-Type","application/json")
			.header("Authorization","bearer "+accessToken)
			
			.when()
			.delete("/user/"+id)
			
			.then()
			.assertThat().statusCode(200).and().contentType(ContentType.JSON)
			//To extract the response
			.extract().response();
			//output will be in string, have to convert to json
			String jsonresponse = response.asString();
			//convert from normal string to json
			JsonPath responsebody = new JsonPath(jsonresponse);
			System.out.println(responsebody.get("message"));
}
}











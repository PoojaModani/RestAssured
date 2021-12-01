package APITest;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class test1 {
public String id;
	
	public static String baseurl = "https://api.trello.com";
	@Test(priority=1)
	public void get_board()
	{
		RestAssured.baseURI = baseurl; //to fetch the base url by restassured
		
		Response response = given().param("key", "c2de62be3ddaa0024e9e2712b6834de8")  // for prerequisite can take parameter/header/cookies
				.param("token","d842206f330e578dc6d0e708be90d8a4019fb3a4d6627b7232c02e8e9e895047")
		
				.when() // condition/can take diff. http methods
				.get("/1/boards/"+id)  // can use any http methods .get/.post/del/.patch
		
				.then() //checking response/applying assertion
				.assertThat().statusCode(200).contentType(ContentType.JSON)
				
				.extract().response();
				
	}
	
	@Test(priority=0)
	public void create_board()
	{
	
		RestAssured.baseURI = baseurl;
		
		Response response1 =given().header("content-Type","applicaton/json") // in given we use header not content type
					.queryParam("key", "c2de62be3ddaa0024e9e2712b6834de8")
					.queryParam("token","d842206f330e578dc6d0e708be90d8a4019fb3a4d6627b7232c02e8e9e895047")
					.queryParam("name","Sample2")
		
		
					.when()
					.post("/1/boards/")
		
					.then()
					.assertThat().statusCode(200).contentType(ContentType.JSON)
		
					.extract().response();
		String jsonresponse = response1.asString();
		JsonPath responsebody = new JsonPath(jsonresponse);
		id = responsebody.get("id");
				}
		
		
	
	@Test(priority=2)
	public void delete_board()
	{
		RestAssured.baseURI = baseurl;
		
		given().param("key", "c2de62be3ddaa0024e9e2712b6834de8")
		.param("token","d842206f330e578dc6d0e708be90d8a4019fb3a4d6627b7232c02e8e9e895047")
		
		.when()
		.delete("/1/boards/"+id)
		
		.then()
		.assertThat().statusCode(200).contentType(ContentType.JSON);
	}
}


package APITest;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
public class test{
	//i am teaching you the get method works
	//https://api.trello.com/1/boards/{id}
	
	public static String baseurl ="https://api.trello.com";
	
	

//create board in trello
@Test(priority = 0,enabled = false)
public void createboard()
{
	RestAssured.baseURI= baseurl;
	//pre-requiste//parameter//header//cookies
			given().queryParam("key", "b4f28fde93f0edf0336a94b014a42a62")
			.queryParam("token", "15303465c48ec10489909f5cce6ec12c183ef49348d4506a6299a07ef99a62cb")
			.queryParam("name", "pooja").header("content-Type","application/json")
			//condition//differetn HTTP methds
			.when()
			.post("/1/boards/")
			//basically checking response //applying assertion //assertion and response
			.then()
			.assertThat().statusCode(200).contentType(ContentType.JSON);
		}

@Test(priority = 1,enabled = false)
public void getboard()
{
	
	//anytime you have to work with rest assured first you have to load the baseurl
	
	RestAssured.baseURI= baseurl;
	
	//pre-requiste//parameter//header//cookies
	given().param("key", "b4f28fde93f0edf0336a94b014a42a62")
	.param("token", "15303465c48ec10489909f5cce6ec12c183ef49348d4506a6299a07ef99a62cb")
	
	//condition//different HTTP methds
	.when()
	.get("/1/boards/r1vAR5GZ")
	//basically checking response //applying assertion //assertion and response
	.then()
	.assertThat().statusCode(200).contentType(ContentType.JSON).and()
	.body("name", equalTo("pooja")).and()
	.body("id", equalTo("61a5ee0501719f525fde9745"));
}


@Test(priority = 2)
public void deleteboard ()
{
	RestAssured.baseURI= baseurl;
	//pre-requiste//parameter//header//cookies
			given().queryParam("key", "b4f28fde93f0edf0336a94b014a42a62")
			.queryParam("token", "15303465c48ec10489909f5cce6ec12c183ef49348d4506a6299a07ef99a62cb")
			.queryParam("name", "pooja").header("content-Type","application/json")
			//condition//differetn HTTP methds
			.when()
			.delete("/1/boards/mlLlaHkg")
			//basically checking response //applying assertion //assertion and response
			.then()
			.assertThat().statusCode(200).contentType(ContentType.JSON);
		}
}
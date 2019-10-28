package test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mongodb.Mongo;

import enums.Situacao;
import io.restassured.*;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.ResponseBodyExtractionOptions;
import model.Student;
import repository.MongoDB;

public class StudentTest extends BasicTest {
	
	private MongoDB mongo = new MongoDB();
	
	Long id = null;
	
	@Test(priority=0)
	public void postApartments() {
		Student student = new Student("RWASDASDA", "01739920058");
         
		id=given()
				.contentType(ContentType.JSON)
				.body(student).
		   when()
				.post("/students").
		   then()
				.statusCode(200)
				.body("name", is(student.getName()))
				.body("cpf", is(student.getCpf())).
		   extract()
		 		.jsonPath().getLong("id");
		
			mongo.MongoInsert(student.getName(), student.getCpf(), id, "POST");	
				
	}
	
//	@Test(priority=3, dataProvider="students")
//	public void postApartmentsSet(Student student) {
//		
//		id = given()
//			.contentType(ContentType.JSON)
//			.body(student).
//		when()
//			.post("/students").
//		then()
//			.statusCode(200).log().body()
//		.extract()
//		 		.jsonPath().getLong("id");
//			;
//		
//		mongo.MongoInsert(student.getName(), student.getCpf(), id, "POST");	
//	}
	
	@Test(priority=1)
	public void getApartments() {
		
		 given()
			.pathParam("id", id)
		.when()
			.get("/students/{id}")
		.then()
			.statusCode(200).log().body()
			
			;
		 mongo.MongoInsert(null, null, id, "GET");
	}
	
//	@Test(priority=20)
//	public void updateApartment() {
//		Student studentToUpdate = new Student("Igor Xavier", "94919778066");
//		
//		given()
//			.contentType(ContentType.JSON)
//			.pathParam("id", id)
//			.body(studentToUpdate)
//		.when()
//			.put("/students/{id}")
//		.then()
//			.statusCode(204);
//		
//		given()
//			.pathParam("id", id)
//		.when()
//			.get("/students/{id}")
//		.then()
//			.body("name", is(studentToUpdate.getName()))
//			.body("cpf", is(studentToUpdate.getCpf()))
//			.log().body();
//	}
//	
//	@Test(priority=25, dependsOnMethods="updateApartment")
//	public void deleteApartment() {
//		
//		given()
//			.pathParam("id", id)
//		.when()
//			.delete("/students/{id}")
//		.then()
//			.statusCode(200);
//		
//		given()
//			.pathParam("id", id)
//		.when()
//			.get("/students/{id}")
//		.then()
//			.statusCode(500);
//	}
	
	@DataProvider(name = "students")
	public Object[][] createData() {
	 return new Object[][] {
	   { new Student("Gilberto", "41020685034") },
	   { new Student("Amanda", "22109483040") },
	   { new Student("Patricia", "70713080043") },
	   { new Student("Lise", "47623794094") },
	   { new Student("Maicon", "90026437058") },
	   { new Student("Everton", "87701006087") },
	   { new Student("Geromel", "18013476030") },
	   { new Student("Paulo", "42936092027") },
	   { new Student("Beatriz", "48695235076") },
	 };
	}
}

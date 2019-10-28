package test;

import org.testng.annotations.BeforeClass;

import io.restassured.*;

public abstract class BasicTest {
	
	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://localhost:8080";
	}

}

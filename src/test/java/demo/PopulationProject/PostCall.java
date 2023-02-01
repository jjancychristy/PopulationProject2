package demo.PopulationProject;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostCall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestAssured.baseURI="https://datausa.io/api/data";
		RequestSpecification req=RestAssured.given().log().all();
		JSONObject js=new JSONObject();
		js.put("ID Nation", "01000US");
		js.put("Nation", "United States");
		js.put("ID Year", "2023");
		js.put("Year", "2023");
		js.put("Population", "3535804067");
		js.put("Slug Nation", "united-states");
		
		
		req.header("Content-type","application/json");
		req.body(js.toString());
		Response response=req.request(Method.POST,"");
		System.out.println(response.statusCode());
		//System.out.println(response.prettyPrint());
		
		
//		"ID Year": 2020,
//        "Year": "2020",
//        "Population": 2535804067
//	
		}

}

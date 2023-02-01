package demo.PopulationProject;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIcall {
	
	//public static void main(String[] args) {
	
		
	    @Test
		public static void getCall() {
		RestAssured.baseURI="https://datausa.io/api/data";
		RequestSpecification req=RestAssured.given().queryParam("measures", "Population").log().all();
		//queryParam("Population", "2535804067")
		Response response=req.request(Method.GET,"");
		System.out.println(response.statusCode());
		JsonPath js = response.jsonPath();
		List <Object>Yearvalues = js.get("data.Year");
		List <Object>Popvalues = js.get("data.Population");
		System.out.println(Yearvalues);
		System.out.println(Popvalues);
		Object[][] data=new Object[10][2];
//		//1st set
		for (int i=0;i<Yearvalues.size();i++) {
			for(int j=0;j<=1;j++)
			{
				data[0][0]=Yearvalues.get(i);
			    data[0][1]=Popvalues.get(j);
			    System.out.println(data[0][0]);
			    System.out.println(data[0][1]);
			    
		}
			
//		data[0][0]=Yearvalues.get(0);
//		data[0][1]=Popvalues.get(0);
//		System.out.println(data[0][0]);
		//2nd set data
//		data[1][0]="seconduser";
//		data[1][1]="secpassword";
//		//3rd set
//		data[2][0]="thirduser";
//		data[2][1]="thirdpwd";
		
		
	}

}

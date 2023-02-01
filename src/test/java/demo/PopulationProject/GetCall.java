package demo.PopulationProject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;

import Files.DataReader;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.mapper.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetCall {
	
	
	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws IOException {
        	
		RestAssured.baseURI = "https://datausa.io/api/data";
		RequestSpecification req = RestAssured.given().queryParam("drilldowns","Nation").queryParam("measures", "Population").queryParam("Year", "2020")
				.log().all();
		Response response = req.request(Method.GET, "");

		System.out.println(response.prettyPrint());
		System.out.println(response.statusCode());
		JsonPath js = response.jsonPath();
		String Year2020 = js.getString("data.Year");
		String Pop2020 = js.getString("data.Population");
		System.out.println(Year2020);
		Map<String,String> myMap1 = new HashMap<String, String>();
	    List<Map<String , String>> myMap  = new ArrayList<Map<String,String>>();
	    myMap1.put("Year",Year2020 );
	    myMap1.put("Population", Pop2020);
	    myMap.add(0,myMap1);
	    System.out.println(myMap);
	    
	    //return [{Year=2020, Population=326569308}]
	    //output [{Year=[2020], Population=[326569308]}]    
	}
	}



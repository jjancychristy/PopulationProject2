package Files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	@Test
	public static void /*List<HashMap<String, String>>*/ getJsonDataToMap() throws IOException {
		//import or add in pom common-io
		String jsonContent = FileUtils.readFileToString(
				new File(System.getProperty("user.dir") + "//src//test//java//Files//Expected.json"),
				StandardCharsets.UTF_8);

		ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
        System.out.println(data);
        //return data;
//        Object[] a = data.toArray();
//        System.out.println(a[0]);
//        String b = a.toString();
//        System.out.println(b.charAt(1));
         // System.out.println(data);

	}

}

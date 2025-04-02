package ddt_practice;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DDTByJsonFile {

	public static void main(String[] args) throws IOException, ParseException {
		JSONParser parser=new JSONParser();
		FileReader file=new FileReader(".\\src\\test\\resources\\Data.json");
		Object javaObj = parser.parse(file);
		JSONObject obj=(JSONObject)javaObj;
		String name=obj.get("name").toString();
		String id=obj.get("id").toString();
		String branch=obj.get("branch").toString();
		String age=obj.get("age").toString();
		String isstudent=obj.get("isstudent").toString();
		System.out.println(name);
		System.out.println(id);
		System.out.println(branch);
		System.out.println(age);
		System.out.println(isstudent);
		

	}

}

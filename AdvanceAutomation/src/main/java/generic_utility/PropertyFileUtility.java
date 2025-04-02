package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {

	
		public String readingDataFromPropFile(String Key) throws IOException
		{
			FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	        Properties prop=new Properties();
	        prop.load(fis);
	        String data=prop.getProperty(Key);
	        
			return data;
	        
		}

	

}

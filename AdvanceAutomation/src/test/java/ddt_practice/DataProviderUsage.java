package ddt_practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderUsage {
@Test(dataProvider="getData")
public void testCase(String firstName,String lastName)
		{
			System.out.println("firstname "+firstName+" lastname "+lastName);
			
		}
@DataProvider
		public Object[][] getData()
				{
			Object[][] objArr=new Object[3][2];
			objArr[0][0]="john";
			objArr[0][1]="sam";
			objArr[1][0]="anu";
			objArr[1][1]="g";
			objArr[2][0]="mini";
			objArr[2][1]="hari";
			return objArr;
			
			
				}

	}



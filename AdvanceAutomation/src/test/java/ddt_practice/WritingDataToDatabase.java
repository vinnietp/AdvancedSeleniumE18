package ddt_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class WritingDataToDatabase {

	public static void main(String[] args) throws SQLException {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Ninza_E18",
			 "root", "sreelakam");
		Statement stmt=conn.createStatement();
		//int result=stmt.executeUpdate("insert into Ninza_CRM_Details values ('safari','http://49.249.28.218:8098/','scott','tiger')");
		int result=stmt.executeUpdate("delete from Ninza_CRM_Details where Browser='chrome'");
		System.out.println(result);
		if(result!=0)
		{
			
			System.out.println("data stored successfully");
			
		}
		else
			System.out.println("operation failed");
		conn.close();

	}

}

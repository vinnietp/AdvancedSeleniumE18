package ddt_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DDTByDatabase {

	public static void main(String[] args) throws SQLException {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Ninza_E18",
			 "root", "sreelakam");
		Statement stmt=conn.createStatement();
		ResultSet result=stmt.executeQuery("select * from Ninza_CRM_Details");
		while(result.next())
		{
			String browser=result.getString(1);
			String url=result.getString(2);
			String un=result.getString(3);
			String pwd=result.getString(4);
			System.out.println(browser);
			System.out.println(url);
			System.out.println(un);
			System.out.println(pwd);
			
		}
		conn.close();
        
	}

}

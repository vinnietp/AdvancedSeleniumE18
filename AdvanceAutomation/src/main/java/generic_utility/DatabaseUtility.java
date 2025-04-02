package generic_utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	Connection Conn;
	public void getDBConnection(String url,String uname,String password)
	{
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			Conn=DriverManager.getConnection(url,uname,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("connection not established");
		}
		
			
	}
	public void closeDBConnection()
	{
		try {
			Conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
		
	}

public ResultSet ExecuteSelectQuery(String query)
{
	ResultSet result=null;
	try
	{
		Statement stmt=Conn.createStatement();
		result=stmt.executeQuery(query);
		
	}
	catch(Exception e)
	{
		
	}
	return result;
	
}
public ResultSet executeNonSelectQuery(String query)
{
ResultSet result=null;
try
{
Statement stmt=Conn.createStatement();
result=stmt.executeQuery(query);	
}
catch(Exception e)
{
		
}
return result;
}

}
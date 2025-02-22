package GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	public Statement stat=null;
	public Connection con=null;
	public void getconnectToDatabase() throws Throwable
	{
			try
			{
				Driver driver=new Driver();
				DriverManager.registerDriver(driver);
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "mmmm");
				stat=con.createStatement();
			}
			catch(Exception e)
			{				
			}
	}
	public String getExecuteQuery(String query,int col) throws SQLException
	{
		String data=null;	
		try
			{
				stat=con.createStatement();
				ResultSet r=stat.executeQuery(query);
			 	data=r.getString(col);
				
			}
			catch(Exception e)
			{				
			}
			return data;
	}
	
	public int getExecuteUpdate(String a) throws SQLException
	{
		int result=0;
		try
		{	
			stat=con.createStatement();
			result=stat.executeUpdate(a);
			return result;
		}
		catch(Exception e)
		{			
		}
		return result;
	}
	public void getclosecon() throws SQLException
	{
		con.close();
	}

}

package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataConnect {
public static Connection getConnection(){
	try{
		Class.forName("com.mysql.jdbs.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/login","root","root");
		return con;
	}catch(Exception ex){
		System.out.println("Database.getConnection() error"+ex.getMessage());
		return null;
	}
}
public static void close(Connection con){
	try{
		con.close();
	}catch(Exception ex){
		
	}
}
}

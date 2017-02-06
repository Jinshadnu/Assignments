package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
public static boolean validate(String user,String pwd){
	Connection con=null;
	PreparedStatement ps=null;
	try{
		con=DataConnect.getConnection();
		ps=con.prepareStatement("Select uname,password from users where uname=? and password=?");
		ps.setString(1,user);
		ps.setString(2,pwd);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			//result found means valid inputs
			return true;
		}
	}catch(SQLException ex){
		System.out.println("Login error..."+ex.getMessage());
		return false;
	}finally{
	DataConnect.close(con);
	}
	return false;
}
}

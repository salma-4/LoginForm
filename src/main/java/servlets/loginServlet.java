package servlets;

import models.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String pass = request.getParameter("password");

        String url = "jdbc:mysql://localhost:3306/users";
        String username = "root";
        String password = "";
        Statement st=null;
        ResultSet res=null;
        try {
			st=(Statement)request.getServletContext().getAttribute("statement");

			 res=st.executeQuery("select * from users where name ='"+name+"'and password ='"+pass+"'");
		         if (res.next()) {
		        	 User user=  new User();
		        	 user.setId(res.getInt("id"));
		        	 user.setPassword(res.getString("password"));
		        	 user.setUserName(res.getString("name"));
		        	 request.getSession().setAttribute("user", user);
		        	 RequestDispatcher dis= request.getRequestDispatcher("showData");
		        	 dis.forward(request, response);
		   
		         }
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
		
		
        
     
      
	}
 
	
	public boolean searchInDB(String name, String password) throws ClassNotFoundException, SQLException {
		
		// connection 
		
		return true;
	}
}

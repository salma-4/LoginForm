package listeners;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class connectDb
 *
 */
public class connectDb implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public connectDb() {
        // TODO Auto-generated constructor stub
    }

	@Override
    public void contextInitialized(ServletContextEvent sce)  { 
    	String url = "jdbc:mysql://localhost:3306/users";
        String username = "root";
        String password = "";
        Statement st=null;
        ResultSet res=null;
     
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				  Connection connection = DriverManager.getConnection(url, username, password);
					st=connection.createStatement();
					sce.getServletContext().setAttribute("statement",st);
			} 
			
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
	
}

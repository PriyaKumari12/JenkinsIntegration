package DataBaseConnection;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.*;

public class DataBaseConnector {
	


	   private Connection connection;
	   private static Statement statement;
	   private static ResultSet rs;

	    @BeforeClass
	    public void setUp() {
	            String databaseURL = "jdbc:mysql://localhost:3306/sakila";
	            String user = "root";
	            String password = "root";
	            connection = null;
	            try {
	                Class.forName("com.mysql.cj.jdbc.Driver");
	                System.out.println("Connecting to Database...");
	                connection = DriverManager.getConnection(databaseURL, user, password);
	                if (connection != null) {
	                    System.out.println("Connected to the Database...");
	                }
	            } catch (SQLException ex) {
	               ex.printStackTrace();
	            }
	            catch (ClassNotFoundException ex) {
	               ex.printStackTrace();
	            }
	    }

	    @Test
	    public void getEmployeesFromDataBase() {
	        try {
	            String query = "select * from customer";
	            statement = connection.createStatement();
	            rs = statement.executeQuery(query);

	            while(rs.next()){
	                int customer_Id= rs.getInt("customer_id");
	                String FisrtName= rs.getString("first_name");
	                String LastName=rs.getString("last_name");
	                String emailaddress= rs.getString("email");
	                System.out.println(customer_Id+"\t"+FisrtName+"\t"+LastName+"\t"+emailaddress);
	            }
	        } catch (SQLException ex) {
	           ex.printStackTrace();
	        }
	    }

	    @AfterClass
	    public void tearDown() {
	      if (connection != null) {
	                try {
	                    System.out.println("Closing Database Connection...");
	                    connection.close();
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	            }
	      }
	}


